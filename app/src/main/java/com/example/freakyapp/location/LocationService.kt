package com.example.freakyapp.location

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.freakyapp.R
import com.example.freakyapp.pagine_punti.LocationAActivity
import com.example.freakyapp.pagine_punti.LocationBActivity
import com.example.freakyapp.pagine_punti.LocationCActivity
import com.example.freakyapp.pagine_punti.LocationDActivity
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LocationService : Service() {

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var locationClient: LocationClient
    private var proximityNotifiedA = false
    private var proximityNotifiedB = false
    private var proximityNotifiedC = false
    private var proximityNotifiedD = false

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        locationClient = DefaultLocationClient(
            applicationContext,
            LocationServices.getFusedLocationProviderClient(applicationContext)
        )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> start()
            ACTION_STOP -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Creazione del canale di notifica (necessario per Android O e successivi)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "location_channel",
                "Location Notifications",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                setSound(null, null)
                enableVibration(false)
            }
            notificationManager.createNotificationChannel(channel)
        }

        locationClient
            .getLocationUpdates(interval = 10000L)
            .catch { e -> e.printStackTrace() }
            .onEach { location ->
                val lat = location.latitude
                val long = location.longitude

                // Aggiorna la notifica con le coordinate correnti
                val updatedNotification = NotificationCompat.Builder(this, "location_channel")
                    .setContentTitle("Tracking location...")
                    .setContentText("Location: ($lat, $long)")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setOngoing(true)
                    .setSound(null) // Silenziosa
                    .setVibrate(null)
                    .build()

                notificationManager.notify(1, updatedNotification)

                // Controlla la prossimità a determinati punti
                checkProximity(location)
            }
            .launchIn(serviceScope)

        // Avvia il servizio in primo piano con una notifica iniziale
        startForeground(
            1, NotificationCompat.Builder(this, "location_channel")
                .setContentTitle("Tracking location...")
                .setContentText("Location: null")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setOngoing(true)
                .setSound(null)
                .setVibrate(null)
                .build()
        )
    }

    private fun stop() {
        stopForeground(STOP_FOREGROUND_DETACH)
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    //45.045033, 9.689155 via IV novembre segreteria
    //45.044898, 9.691746 miva
    //45.044905, 9.690076 cancello aula magna
    //45.044893, 9.689791 palestre B

    //45.05640, 9.70219 torrione fodesta
    //45.055291, 9.714616 impianto idrovoro finarda
    //45.081337, 9.899543 pontos san nazzaro
    //45.066937, 9.707857 pontos san rocco

    private fun checkProximity(location: Location) {
        val locationA = Pair(45.0564, 9.7021) // Torrione fodesta
        val locationB = Pair(45.0552, 9.7146) // Finarda
        val locationC = Pair(45.0813, 9.8995) //pontos san nazzaro
        val locationD = Pair(45.0669, 9.7078) //pontos san rocco
        val proximityThreshold = 0.000675 // Tolleranza per la distanza (in gradi lat-long, distanza desiderata(metri)/distanza per grado(111000 metri)

        val lat = location.latitude
        val long = location.longitude

        when {
            isWithinRange(lat, long, locationA.first, locationA.second, proximityThreshold) && !proximityNotifiedA -> {
                proximityNotifiedA = true
                sendNotification(
                    title = "Sei vicino a Torrione Fodesta",
                    message = "Tocca per aprire",
                    targetActivity = LocationAActivity::class.java
                )
            }
            isWithinRange(lat, long, locationB.first, locationB.second, proximityThreshold) && !proximityNotifiedB -> {
                proximityNotifiedB = true
                sendNotification(
                    title = "Sei vicino a Impianto idrovoro Finarda",
                    message = "Tocca per aprire",
                    targetActivity = LocationBActivity::class.java
                )
            }
            isWithinRange(lat, long, locationC.first, locationC.second, proximityThreshold) && !proximityNotifiedC -> {
                proximityNotifiedC = true
                sendNotification(
                    title = "Sei vicino a Ponte di San Nazzaro",
                    message = "Tocca per aprire",
                    targetActivity = LocationCActivity::class.java
                )
            }
            isWithinRange(lat, long, locationD.first, locationD.second, proximityThreshold) && !proximityNotifiedD -> {
                proximityNotifiedD = true
                sendNotification(
                    title = "Sei vicino a Ponte di San Rocco",
                    message = "Tocca per aprire",
                    targetActivity = LocationDActivity::class.java
                )
            }
            // Se esci dal range, resetta lo stato per ricevere nuovamente le notifiche
            !isWithinRange(lat, long, locationA.first, locationA.second, proximityThreshold) -> proximityNotifiedA = false
            !isWithinRange(lat, long, locationB.first, locationB.second, proximityThreshold) -> proximityNotifiedB = false// Se esci dal range, resetta lo stato per ricevere nuovamente le notifiche
            !isWithinRange(lat, long, locationC.first, locationC.second, proximityThreshold) -> proximityNotifiedC = false
            !isWithinRange(lat, long, locationD.first, locationD.second, proximityThreshold) -> proximityNotifiedD = false
        }
    }

    private fun isWithinRange(
        lat1: Double, long1: Double, lat2: Double, long2: Double, threshold: Double
    ): Boolean {
        val distanceLat = Math.abs(lat1 - lat2)
        val distanceLong = Math.abs(long1 - long2)
        return distanceLat < threshold && distanceLong < threshold
    }

    private fun sendNotification(title: String, message: String, targetActivity: Class<*>) {
        val intent = Intent(this, targetActivity).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, "location_channel")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify((title + message).hashCode(), notification)
    }

    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
    }
}

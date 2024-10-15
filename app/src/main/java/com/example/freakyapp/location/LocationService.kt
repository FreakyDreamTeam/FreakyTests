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
import com.example.freakyapp.pagine_punti.LocationFActivity
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
    private var proximityNotifiedF = false
    private var proximityNotifiedViaNasolini = false

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
        val locKaefu = Pair(45.045596484882495, 9.68391723041813)
        val locSegreteria = Pair(45.045088, 9.689127)
        val locMagna = Pair(45.04488297840383, 9.69051569813549)
        val locPalazzinaD = Pair(45.04459450460115, 9.691312784599218)
        val locMiva = Pair(45.04486912707834, 9.691730345675278)
        val locCheope = Pair(45.04576896475646, 9.687562865342748)
        val locUnieuro = Pair(45.05423563404899, 9.673924335025156)
        val locMc = Pair(45.05471521895691, 9.656061633442667)
        val locPorsche = Pair(45.05513709182227, 9.64521798075403)
        val locVia24Maggio = Pair(45.05263114136313, 9.676769886599676)
        val locViaNasolini = Pair(45.04421515600366, 9.691453450875652)
        val locIngressoB = Pair(45.044977700997414, 9.68926779912927)
        val locAssicurazione = Pair(45.0459934051227, 9.684511251921448)
        val locBarrieraGenova = Pair(45.046498955529934, 9.685403188416533)
        val locPonteC = Pair(45.04424172008859, 9.689251580411826)
        val locPalestra1 = Pair(45.044865076674824, 9.690070537357856)

        val locationA = Pair(45.0564, 9.7021) // Torrione fodesta
        val locationB = Pair(45.0552, 9.7146) // Finarda
        val locationC = Pair(45.0813, 9.8995) //pontos san nazzaro
        val locationD = Pair(45.0669, 9.7078) //pontos san rocco
        val locationF = Pair(45.0517, 9.7056)  // Stazione Piacenza
        val proximityThreshold = 0.00016875 // Tolleranza per la distanza (in gradi lat-long, distanza desiderata(metri)/distanza per grado(111000 metri)

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
            isWithinRange(lat, long, locationF.first, locationF.second, proximityThreshold) && !proximityNotifiedF -> {
                proximityNotifiedF = true
                sendNotification(
                    title = "Sei vicino a Stazione di Piacenza",
                    message = "Tocca per aprire",
                    targetActivity = LocationFActivity::class.java
                )
            }
            isWithinRange(lat, long, locViaNasolini.first, locViaNasolini.second, proximityThreshold) && !proximityNotifiedViaNasolini -> {
                proximityNotifiedViaNasolini = true
                sendNotification(
                    title = "Sei vicino a Via Nasolini",
                    message = "Tocca per aprire",
                    targetActivity = LocationFActivity::class.java
                )
            }
            // Se esci dal range, resetta lo stato per ricevere nuovamente le notifiche
            !isWithinRange(lat, long, locationA.first, locationA.second, proximityThreshold) -> proximityNotifiedA = false
            !isWithinRange(lat, long, locationB.first, locationB.second, proximityThreshold) -> proximityNotifiedB = false// Se esci dal range, resetta lo stato per ricevere nuovamente le notifiche
            !isWithinRange(lat, long, locationC.first, locationC.second, proximityThreshold) -> proximityNotifiedC = false
            !isWithinRange(lat, long, locationD.first, locationD.second, proximityThreshold) -> proximityNotifiedD = false
            !isWithinRange(lat, long, locationF.first, locationF.second, proximityThreshold) -> proximityNotifiedF = false
            !isWithinRange(lat, long, locViaNasolini.first, locViaNasolini.second, proximityThreshold) -> proximityNotifiedViaNasolini = false
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

        // Usa un requestCode unico basato sull'hash di titolo + messaggio
        val requestCode = (title + message).hashCode()

        val pendingIntent = PendingIntent.getActivity(
            this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
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

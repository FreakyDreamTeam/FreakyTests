package com.example.testbackgroundlocation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.math.*

class LocationService : Service() {

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var locationClient: LocationClient

    // Soglia di distanza (in km) per inviare la notifica (100 metri)
    private val thresholdDistance = 0.1

    //45.058140, 9.489215

    // Coordinate target
    private val targetCoordinates = listOf(
        Pair(45.05814, 9.48921), // Coordinate 1 (ad esempio Coop Sarmatone)
        Pair(41.90278, 12.49636) // Coordinate 2 (ad esempio Roma)
    )

    // Variabile per tenere traccia dello stato di notifica
    private var notified = false

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
        val notification = NotificationCompat.Builder(this, "location_channel")
            .setContentTitle("Tracking location...")
            .setContentText("Location: null")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setOngoing(true)
            .setSound(null) // Disabilita il suono della notifica
            .setVibrate(null) // Disabilita la vibrazione della notifica

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Creazione del canale di notifica (necessario per Android O e successivi)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "location_channel",
                "Location Notifications",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                // Disabilita suono e vibrazione per il canale
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
                val updatedNotification = notification.setContentText(
                    "Location: ($lat, $long)"
                )
                notificationManager.notify(1, updatedNotification.build())

                // Controllo della vicinanza alle coordinate target
                checkProximity(lat, long)
            }
            .launchIn(serviceScope)

        startForeground(1, notification.build())
    }

    private fun stop() {
        stopForeground(STOP_FOREGROUND_DETACH)
        stopSelf()
    }

    private fun checkProximity(currentLat: Double, currentLon: Double) {
        var isWithinRange = false

        for ((targetLat, targetLon) in targetCoordinates) {
            val distance = calculateDistance(currentLat, currentLon, targetLat, targetLon)
            if (distance <= thresholdDistance) {
                isWithinRange = true
                break
            }
        }

        if (isWithinRange && !notified) {
            sendNotification()
            notified = true
        } else if (!isWithinRange && notified) {
            // Resetta lo stato di notifica quando si esce dalla zona
            notified = false
        }
    }

    private fun calculateDistance(
        lat1: Double, lon1: Double,
        lat2: Double, lon2: Double
    ): Double {
        val earthRadius = 6371.0 // Raggio della Terra in km
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = sin(dLat / 2) * sin(dLat / 2) +
                cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) *
                sin(dLon / 2) * sin(dLon / 2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return earthRadius * c
    }

    private fun sendNotification() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(this, TargetActivity::class.java) // Sostituisci con l'attività di destinazione
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, "location_channel")
            .setContentTitle("Sei vicino!")
            .setContentText("Clicca qui per ulteriori informazioni.")
            .setSmallIcon(R.drawable.ic_launcher_background) // Sostituisci con la tua icona
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(2, notification)
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
    }
}

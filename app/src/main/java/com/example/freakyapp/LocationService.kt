package com.example.freakyapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class LocationService : Service(), LocationListener {

    //45.058549, 9.445008
    private lateinit var locationManager: LocationManager
    private val targetLatitude = 45.058549 // Inserisci qui la latitudine target
    private val targetLongitude = 9.445008 // Inserisci qui la longitudine target

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startMyOwnForeground()
        } else {
            startForeground(1, Notification())
        }

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
        } catch (ex: SecurityException) {
            Log.e("LocationService", "Security Exception, no location available")
        }

        return START_STICKY
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startMyOwnForeground() {
        val channelId = "example.permanence"
        val channelName = "Background Service"
        val chan = NotificationChannel(
            channelId, channelName, NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = getColor(android.R.color.holo_red_dark)
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val manager = (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        manager.createNotificationChannel(chan)

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
        val notification = notificationBuilder.setOngoing(true)
            .setContentTitle("App is tracking your location")
            .setPriority(NotificationManager.IMPORTANCE_MIN)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(2, notification)
    }

    override fun onLocationChanged(location: Location) {
        val targetLocation = Location("").apply {
            latitude = targetLatitude
            longitude = targetLongitude
        }

        val distance = location.distanceTo(targetLocation)

        if (distance < 100) {  // Se la distanza è minore di 100 metri
            sendNotification()
        }
    }

    private fun sendNotification() {
        val notificationIntent = Intent(this, YourActivity::class.java) // Imposta l'activity di destinazione
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, "example.permanence")
            .setContentTitle("Sei vicino alla tua destinazione!")
            .setContentText("Tocca per vedere i dettagli.")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(3, notification)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}

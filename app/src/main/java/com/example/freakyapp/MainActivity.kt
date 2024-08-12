package com.example.freakyapp

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.freakyapp.ui.theme.FreakyAppTheme
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng

class MainActivity : ComponentActivity() {

    private val LOCATION_PERMISSION_REQUEST_CODE = 1001
    private lateinit var geofencingClient: GeofencingClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inizializza il GeofencingClient
        geofencingClient = LocationServices.getGeofencingClient(this)

        // Richiede i permessi prima di impostare il contenuto della UI
        checkLocationPermission()

        enableEdgeToEdge()
        setContent {
            FreakyAppTheme {
                MainScreen()  // Chiamata alla funzione principale che gestisce l'UI
            }
        }

        // Aggiungi geofence dopo aver controllato i permessi
        addGeofence(LatLng(45.052057, 9.671251), 100f)

        // Gestisci l'intent ricevuto se la notifica viene cliccata
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        if (intent != null) {
            super.onNewIntent(intent)
        }
        intent?.let {
            handleIntent(it)
        }
    }

    private fun handleIntent(intent: Intent) {
        val navigateTo = intent.getStringExtra("navigateTo")
        if (navigateTo == "sections") {
            // Logica per navigare alla sezione "sections"
        }
    }

    private fun checkLocationPermission() {
        // Controlla se il permesso di localizzazione in primo piano è già stato concesso
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Richiede il permesso per la localizzazione in primo piano
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        } else {
            // Se il permesso è già stato concesso, richiede il permesso per la localizzazione in background (solo Android 10+)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
                }
            }
        }
    }

    // Gestisce il risultato della richiesta del permesso
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // Permesso concesso, puoi procedere con l'accesso alla localizzazione
            } else {
                // Permesso negato, mostra un messaggio all'utente
                Toast.makeText(this, "Permesso di localizzazione negato. L'app potrebbe non funzionare correttamente.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun addGeofence(location: LatLng, radius: Float) {
        val geofence = Geofence.Builder()
            .setRequestId("GEOFENCE_ID")
            .setCircularRegion(location.latitude, location.longitude, radius)
            .setExpirationDuration(Geofence.NEVER_EXPIRE)
            .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_EXIT)
            .build()

        val geofencingRequest = GeofencingRequest.Builder()
            .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
            .addGeofence(geofence)
            .build()

        val geofencePendingIntent: PendingIntent by lazy {
            val intent = Intent(this, GeofenceBroadcastReceiver::class.java)
            PendingIntent.getBroadcast(
                this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        geofencingClient.addGeofences(geofencingRequest, geofencePendingIntent)
            .addOnSuccessListener {
                // Geofence aggiunta con successo
            }
            .addOnFailureListener {
                // Errore nell'aggiungere la geofence
            }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { MyBottomAppBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { /* Schermata home */ }
                composable("sections") { SectionsScreen() }  // Schermata per la sezione "sections"
            }
        }
    }
}

@Composable
fun SectionsScreen() {
    // Contenuto della sezione "sections"
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FreakyAppTheme {
        MainScreen()
    }
}

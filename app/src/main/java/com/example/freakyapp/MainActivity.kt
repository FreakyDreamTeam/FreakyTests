package com.example.freakyapp

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.example.freakyapp.location.LocationService
import com.example.freakyapp.ui.theme.FreakyAppTheme
import org.osmdroid.config.Configuration


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inizializza la configurazione di OpenStreetMap
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.POST_NOTIFICATIONS
            ),
            0
        )
        enableEdgeToEdge()
        setContent {
            FreakyAppTheme {
                MainScreen()  // Chiamata alla funzione principale che gestisce l'UI
            }
        }
    }


@Composable
fun MainScreen() {

    // Ottieni il contesto
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        Intent(context, LocationService::class.java).apply {
            action = LocationService.ACTION_START
            // Avvia il servizio usando il contesto ottenuto
            context.startService(this)
        }
    }

    Scaffold(
        bottomBar = { MyBottomAppBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}}

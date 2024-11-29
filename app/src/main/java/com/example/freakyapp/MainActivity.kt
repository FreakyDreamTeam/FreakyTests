package com.example.freakyapp

import Sections
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Build
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.freakyapp.location.LocationService
import com.example.freakyapp.ui.theme.FreakyAppTheme
import org.osmdroid.config.Configuration

class MainActivity : ComponentActivity() {

    private val showDialog = mutableStateOf(false)

    private val requestPermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allGranted = permissions.values.all { it }
            if (allGranted) {
                // Tutti i permessi sono stati concessi, avvia il servizio
                startLocationService()
            } else {
                showDialog.value = true
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Impostazione per il layout edge-to-edge
        setContent {
            FreakyAppTheme {
                MainScreen(window) // Imposta il contenuto della schermata principale
            }
        }

        // Controlla i permessi all'avvio
        if (!areAllPermissionsGranted()) {
            // Richiedi i permessi se non sono già concessi
            requestPermissions()
        } else {
            // Avvia il servizio se i permessi sono concessi
            startLocationService()
        }
    }

    private fun areAllPermissionsGranted(): Boolean {
        val permissions = arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.POST_NOTIFICATIONS
        )
        return permissions.all { permission ->
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun requestPermissions() {
        requestPermissionsLauncher.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.POST_NOTIFICATIONS
            )
        )
    }

    private fun startLocationService() {
        val intent = Intent(this, LocationService::class.java).apply {
            action = LocationService.ACTION_START
        }
        startService(intent)
    }


    private fun finishApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAndRemoveTask()
        } else {
            finish()
        }
    }


    @Composable
    fun MainScreen(window: Window) {
        if(showDialog.value){
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = { Text("Permessi richiesti") },
                text = { Text("Devi concedere i permessi per usare questa app. Vuoi riprovare?") },
                confirmButton = {
                    Button(onClick = {
                        showDialog.value = false
                        requestPermissions()
                    }
                    ) {
                        Text("OK")

                    }
                },
                dismissButton = {
                    Button(onClick = {
                        showDialog.value = false
                        finishApp()
                    }) {
                        Text("Annulla")
                    }
                }
            )
        }


        // Ottieni il contesto per la navigazione
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                MyBottomAppBar()
            },
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.navigationBars) // Considera la barra di navigazione per il layout
        ) { innerPadding ->

            // Imposta il colore della barra di navigazione in base al tema
            if (isSystemInDarkTheme()) {
                window.navigationBarColor = colorResource(R.color.verdenegro).toArgb()
            } else {
                window.navigationBarColor = colorResource(R.color.verdechiaro).toArgb()
            }

            // Layout della schermata principale
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { Home() }
                    composable("map") { Map(navController) }
                    composable("sections") { Sections() }
                }
            }
        }
    }

}


package com.example.freakyapp

import Sections
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.freakyapp.location.LocationService
import com.example.freakyapp.ui.theme.FreakyAppTheme
import org.osmdroid.config.Configuration

class MainActivity : ComponentActivity() {

    private val requestPermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allGranted = permissions.values.all { it }
            if (allGranted) {
                // Tutti i permessi sono stati concessi
                startLocationService()
            } else {
                // Mostra il dialog prima di chiudere l'app
                runOnUiThread {
                    showPermissionRequiredDialog()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreakyAppTheme {
                MainScreen(window)
            }
        }

        // Controlla i permessi all'avvio
        if (!areAllPermissionsGranted()) {
            // Richiedi i permessi
            requestPermissions()
        } else {
            // Avvia il servizio solo se i permessi sono concessi
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

    private fun showPermissionRequiredDialog() {
        runOnUiThread {
            AlertDialog.Builder(this)
                .setTitle("Permessi richiesti")
                .setMessage("Devi concedere i permessi per usare questa app. Vuoi riprovare?")
                .setCancelable(false)
                .setPositiveButton("Riprova") { _, _ ->
                    // Richiedi i permessi di nuovo
                    requestPermissions()
                }
                .setNegativeButton("Esci") { _, _ ->
                    // Chiudi l'app
                    finishApp()
                }
                .show()
        }

    }

    private fun finishApp() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            finishAndRemoveTask()
        } else {
            finish()
        }
    }
}


@Composable
fun MainScreen(window: Window) {
    // Ottieni il contesto
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            MyBottomAppBar()
        },
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.navigationBars) // Considera la barra di navigazione per il layout
    ) { innerPadding ->

        if(isSystemInDarkTheme()){
            window.navigationBarColor = colorResource(R.color.verdenegro).toArgb()
        }else{
            window.navigationBarColor = colorResource(R.color.verdechiaro).toArgb()
        }

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


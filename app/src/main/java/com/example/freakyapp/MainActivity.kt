package com.example.freakyapp

import Sections
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        // Ottieni il contesto
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { MyBottomAppBar() }  // Barra inferiore di navigazione
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(colorResource(R.color.Verdechiaro))
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "home"  // Schermata iniziale
                ) {
                    composable("home") { Home() }
                    composable("map") { Map(navController) }  // Schermata della mappa
                    composable("sections") { Sections() }  // Schermata delle sezioni
                }
            }
        }
    }

    @Preview
    @Composable
    fun MainScreen2() {
        // Ottieni il contesto
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { MyBottomAppBar() }  // Barra inferiore di navigazione
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(colorResource(R.color.Verdechiaro))
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "home"  // Schermata iniziale
                ) {
                    composable("home") { Home() }
                    composable("map") { Map(navController) }  // Schermata della mappa
                    composable("sections") { Sections() }  // Schermata delle sezioni
                }
            }
        }
    }
}

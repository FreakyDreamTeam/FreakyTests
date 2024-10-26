package com.example.freakyapp

import Sections
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
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
            bottomBar = {
                MyBottomAppBar()
            },
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.navigationBars) // Considera la barra di navigazione per il layout
        ) { innerPadding ->

            if(isSystemInDarkTheme()){
                window.navigationBarColor = getColor(R.color.verdenegro)
            }else{
                window.navigationBarColor = getColor(R.color.verdechiaro)
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
}

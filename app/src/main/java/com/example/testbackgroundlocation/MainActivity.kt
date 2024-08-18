package com.example.testbackgroundlocation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.testbackgroundlocation.ui.theme.TestBackgroundLocationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            0
        )
        setContent {
            TestBackgroundLocationTheme {
                Home()
            }
        }
    }
}

@Composable
fun Home() {
    // Ottieni il contesto
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = {
                Intent(context, LocationService::class.java).apply {
                    action = LocationService.ACTION_START
                    // Avvia il servizio usando il contesto ottenuto
                    context.startService(this)
                }

            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = "Start")
        }

        Button(
            onClick = {
                Intent(context, LocationService::class.java).apply {
                    action = LocationService.ACTION_STOP
                    // Ferma il servizio usando il contesto ottenuto
                    context.startService(this)
                }
            }
        ) {
            Text(text = "Stop")
        }
    }
}


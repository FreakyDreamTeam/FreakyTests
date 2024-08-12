package com.example.freakyapp

import android.Manifest
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
import com.example.freakyapp.ui.theme.FreakyAppTheme
import org.osmdroid.config.Configuration


class MainActivity : ComponentActivity() {

    private val LOCATION_PERMISSION_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {

        // Configurazione di osmdroid
        Configuration.getInstance().load(this, getSharedPreferences("osm_pref", MODE_PRIVATE))

        super.onCreate(savedInstanceState)

        // Richiede i permessi prima di impostare il contenuto della UI
        checkLocationPermission()

        enableEdgeToEdge()
        setContent {
            FreakyAppTheme {
                MainScreen()  // Chiamata alla funzione principale che gestisce l'UI
            }
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
                // Avvia il servizio di localizzazione
                val intent = Intent(this, LocationService::class.java)
                startService(intent)
            } else {
                Toast.makeText(this, "Permesso di localizzazione negato. L'app potrebbe non funzionare correttamente.", Toast.LENGTH_LONG).show()
            }
        }

    }


}

@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = { MyBottomAppBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FreakyAppTheme {
        MainScreen()
    }
}

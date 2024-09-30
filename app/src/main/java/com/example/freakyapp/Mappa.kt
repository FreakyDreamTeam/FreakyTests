package com.example.freakyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
fun Map(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            MapView(context).apply {
                // Configura la mappa
                setMultiTouchControls(true)
                controller.setZoom(15.0)
                controller.setCenter(GeoPoint(45.0517, 9.7056))  // Stazione Piacenza

                //45.051740, 9.705651
                // Aggiungi un marker
                val startMarker = Marker(this)
                startMarker.position = GeoPoint(45.0517, 9.7056)  // Stazione Piacenza
                startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                startMarker.title = "Marker in London"
                overlays.add(startMarker)
            }
        },
        update = { mapView ->
            // Qui puoi aggiornare la mappa se necessario
        }
    )
}
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

                // Aggiungi un marker
                val stazioneMarker = Marker(this)
                stazioneMarker.position = GeoPoint(45.0517, 9.7056)  // Stazione Piacenza
                stazioneMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                stazioneMarker.title = "Marker Stazione"
                overlays.add(stazioneMarker)

                // Aggiungi un marker
                val torrioneMarker = Marker(this)
                torrioneMarker.position = GeoPoint(45.0564, 9.7021)  // Torrione
                torrioneMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                torrioneMarker.title = "Marker Torrione"
                overlays.add(torrioneMarker)

                // Aggiungi un marker
                val finardaMarker = Marker(this)
                finardaMarker.position = GeoPoint(45.0552, 9.7146)  // Finarda
                finardaMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                finardaMarker.title = "Marker Impianto Finarda"
                overlays.add(finardaMarker)

                // Aggiungi un marker
                val nazzaroMarker = Marker(this)
                nazzaroMarker.position = GeoPoint(45.0813, 9.8995)  // Nazzaro
                nazzaroMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                nazzaroMarker.title = "Marker Ponte San Nazzaro"
                overlays.add(nazzaroMarker)

                // Aggiungi un marker
                val roccoMarker = Marker(this)
                roccoMarker.position = GeoPoint(45.0669, 9.7078)  // Rocco
                roccoMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                roccoMarker.title = "Marker Ponte San Rocco"
                overlays.add(roccoMarker)


            }
        },
        update = { mapView ->
            // Qui puoi aggiornare la mappa se necessario
        }
    )
}
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

//@Composable
//fun Map(){
//    Box(modifier = Modifier.fillMaxSize()){
//        Column (
//            modifier = Modifier
//                .fillMaxSize()
//                .align(Alignment.Center),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ){
//            Image(
//                painter = painterResource(id = R.drawable.mantide),
//                contentDescription = "seconda immagine"
//            )
//            Text(text = "mantide")
//        }
//    }
//}

@Composable
fun Map(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            MapView(context).apply {
                // Configura la mappa
                setMultiTouchControls(true)
                controller.setZoom(5.0)
                controller.setCenter(GeoPoint(51.5074, -0.1278))  // Esempio: Londra

                // Aggiungi un marker
                val startMarker = Marker(this)
                startMarker.position = GeoPoint(51.5074, -0.1278)  // Londra
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
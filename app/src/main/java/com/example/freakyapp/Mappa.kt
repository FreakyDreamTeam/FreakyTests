package com.example.freakyapp

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.freakyapp.pagine_punti.*
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
fun Map(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current  // Ottieni il contesto

    // Imposta la configurazione di osmdroid
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { ctx ->
            MapView(ctx).apply {
                Configuration.getInstance().userAgentValue = ctx.packageName
                setMultiTouchControls(true)

                // Imposta la posizione e lo zoom iniziale su Roma
                val centro = GeoPoint(45.083383, 9.798143) // Coordinate per Centro ciclovia
                controller.setZoom(13.0)  // Livello di zoom ravvicinato
                controller.setCenter(centro)  // Centra la mappa

                // Aggiungi i marker
                addMarker(this, GeoPoint(45.051949, 9.706057), "Stazione PC", context, StazionePCActivity::class.java)
                addMarker(this, GeoPoint(45.05640, 9.70219), "Torrione Fodesta", context, TorrioneFodestaActivity::class.java)
                addMarker(this, GeoPoint(45.0566477, 9.7073399), "Ex Centrale Emilia", context, ExCentraleEmiliaActivity::class.java)
                addMarker(this, GeoPoint(45.06465244770296, 9.874184362634118), "Ponte delle Ceramiche", context, PonteDelleCeramicheActivity::class.java)
                addMarker(this, GeoPoint(45.060207, 9.705384), "Ponte ferroviario", context, PonteFerroviarioActivity::class.java)
                addMarker(this, GeoPoint(45.061327, 9.703623), "Ponte San Rocco", context, PonteSanRoccoActivity::class.java)
                addMarker(this, GeoPoint(45.065589, 9.734353), "Ponte autostrada", context, PonteAutostradaActivity::class.java)
                addMarker(this, GeoPoint(45.07793231541073, 9.745598741245159), "Ponte AV", context, PonteAVActivity::class.java)
                addMarker(this, GeoPoint(45.057645230252874, 9.707142230260848), "Nino Bixio", context, NinoBixioActivity::class.java)
                addMarker(this, GeoPoint(45.05784320256016, 9.713248336552905), "Isolotto Maggi", context, IsolottoMaggiActivity::class.java)
                addMarker(this, GeoPoint(45.055291, 9.714616), "Impianto idrovoro Finarda", context, ImpiantoIdrovoroFinardaActivity::class.java)
                addMarker(this, GeoPoint(45.07208510840803, 9.86782820916427), "Centrale Caorso", context, CentraleCaorsoActivity::class.java)
                addMarker(this, GeoPoint(45.0655013, 9.8390417), "Fontanella Roncarolo", context, FontanellaRoncaroloActivity::class.java)
                addMarker(this, GeoPoint(45.0768997, 9.8943338), "Area sosta S. Nazzaro", context, AreaSostaSNazzaroActivity::class.java)
                addMarker(this, GeoPoint(45.081887347122866, 9.898561404386227), "Ponte S. Nazzaro", context, PonteSNazzaroActivity::class.java)
                addMarker(this, GeoPoint(45.081887347122866, 9.898561404386227), "Passaggio su strada Fossadello", context, PassaggioSuStradaFossadelloActivity::class.java)
                addMarker(this, GeoPoint(45.055930, 9.702823), "Partenza", context, PartenzaActivity::class.java)
                addMarker(this, GeoPoint(45.055930, 9.702823), "Ciclabile Ponte S. Rocco", context, CiclabilePonteSRoccoActivity::class.java)
                addMarker(this, GeoPoint(45.058143, 9.700901), "Discesa dal ponte", context, DiscesaDalPonteActivity::class.java)
                addMarker(this, GeoPoint(45.09332194310006, 9.904885527112402), "Isola Serafini", context, IsolaSerafiniActivity::class.java)
                addMarker(this, GeoPoint(45.084375202603546, 9.865746896312627), "Oasi naturalistica dell'Isola del Pinedo", context, OasiNaturalisticaPinedoActivity::class.java)
                addMarker(this, GeoPoint(45.05592174155956, 9.707834527001006), "Centrale termoelettrica ex 'Levante'", context, CentraleTermoelettricaLevanteActivity::class.java)
                addMarker(this, GeoPoint(45.058188224501244, 9.705801096960299), "LEAP", context, LeapActivity::class.java)
                addMarker(this, GeoPoint(45.05750958022169, 9.733062031555836), "Impianto idrovoro Borgoforte", context, ImpiantoIdrovoroBorgoforteActivity::class.java)
                addMarker(this, GeoPoint(45.05949270337371, 9.732816388159177), "Depuratore Borgoforte", context, DepuratoreBorgoforteActivity::class.java)
                addMarker(this, GeoPoint(45.05949270337371, 9.732816388159177), "Termovalorizzatore Borgoforte", context, TermovalorizzatoreBorgoforteActivity::class.java)
                addMarker(this, GeoPoint(45.09478508718558, 9.904594069179499), "Centrale idroelettrica Isola Serafini", context, CentraleIdroelettricaIsolaSerafiniActivity::class.java)
                addMarker(this, GeoPoint(45.105883386456426, 9.736189359512233), "Impianto idrovoro del Consorzio Muzio", context, ImpiantoIdrovoroConsorzioMuzioActivity::class.java)
                addMarker(this, GeoPoint(45.05521654110569, 9.800781841884934), "Impianto idrovoro Armalunga", context, ImpiantoIdrovoroArmalungaActivity::class.java)
                addMarker(this, GeoPoint(45.0760107, 9.8925903), "La finestra sul Po", context, FinestraSulPoActivity::class.java)
                addMarker(this, GeoPoint(45.04932571085476, 9.81132763801647), "Agriturismo Boschi Celati", context, AgriturismoBoschiCelatiActivity::class.java)
                addMarker(this, GeoPoint(45.0586710, 9.8346721), "Trattoria Magaton", context, TrattoriaMagatonActivity::class.java)
                addMarker(this, GeoPoint(45.065326833971575, 9.840337259324594), "Trattoria Tonoli", context, TrattoriaTonoliActivity::class.java)
                addMarker(this, GeoPoint(45.100418177127146, 9.793586156270205), "Trattoria dei viaggiatori", context, TrattoriaDeiViaggiatoriActivity::class.java)
                addMarker(this, GeoPoint(45.1130937, 9.7596986), "Trattoria Chalet sul Po", context, TrattoriaChaletSulPoActivity::class.java)
                addMarker(this, GeoPoint(45.0655449, 9.8379189), "La tana di Roncarolo", context, TanaDiRoncaroloActivity::class.java)
                addMarker(this, GeoPoint(45.07589139606873, 9.895138352448015), "Trattoria Il Milanista", context, TrattoriaIlMilanistaActivity::class.java)
                addMarker(this, GeoPoint(45.07815930003141, 9.756850391), "Distributore d'acqua Mortizza", context, DistributoreAcquaMortizzaActivity::class.java)
            }
        }
    )
}

/**
 * Funzione di supporto per aggiungere un marker alla mappa
 */
fun addMarker(mapView: MapView, geoPoint: GeoPoint, title: String, context: android.content.Context, targetActivity: Class<*>) {
    val marker = Marker(mapView).apply {
        position = geoPoint
        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        this.title = title
        setOnMarkerClickListener { _, _ ->
            // Verifica che il context sia un'istanza di Activity
            val activity = context as? Activity
            if (activity != null) {
                val intent = Intent(activity, targetActivity)
                activity.startActivity(intent)
            } else {
                // Log o gestione dell'errore
                println("Context non è un'istanza di Activity.")
            }
            true
        }
    }
    mapView.overlays.add(marker)  // Aggiungi il marker agli overlay della mappa
}

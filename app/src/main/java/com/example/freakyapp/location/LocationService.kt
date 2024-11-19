package com.example.freakyapp.location

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.freakyapp.R
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.example.freakyapp.pagine_punti.StazionePCActivity
import com.example.freakyapp.pagine_punti.TorrioneFodestaActivity
import com.example.freakyapp.pagine_punti.ExCentraleEmiliaActivity
import com.example.freakyapp.pagine_punti.PonteDelleCeramicheActivity
import com.example.freakyapp.pagine_punti.PonteFerroviarioActivity
import com.example.freakyapp.pagine_punti.PonteSanRoccoActivity
import com.example.freakyapp.pagine_punti.PonteAutostradaActivity
import com.example.freakyapp.pagine_punti.PonteAVActivity
import com.example.freakyapp.pagine_punti.NinoBixioActivity
import com.example.freakyapp.pagine_punti.IsolottoMaggiActivity
import com.example.freakyapp.pagine_punti.ImpiantoIdrovoroFinardaActivity
import com.example.freakyapp.pagine_punti.CentraleCaorsoActivity
import com.example.freakyapp.pagine_punti.FontanellaRoncaroloActivity
import com.example.freakyapp.pagine_punti.AreaSostaSNazzaroActivity
import com.example.freakyapp.pagine_punti.PonteSNazzaroActivity
import com.example.freakyapp.pagine_punti.PassaggioSuStradaFossadelloActivity
import com.example.freakyapp.pagine_punti.PartenzaActivity
import com.example.freakyapp.pagine_punti.CiclabilePonteSRoccoActivity
import com.example.freakyapp.pagine_punti.DiscesaDalPonteActivity
import com.example.freakyapp.pagine_punti.IsolaSerafiniActivity
import com.example.freakyapp.pagine_punti.OasiNaturalisticaPinedoActivity
import com.example.freakyapp.pagine_punti.CentraleTermoelettricaLevanteActivity
import com.example.freakyapp.pagine_punti.LeapActivity
import com.example.freakyapp.pagine_punti.ImpiantoIdrovoroBorgoforteActivity
import com.example.freakyapp.pagine_punti.DepuratoreBorgoforteActivity
import com.example.freakyapp.pagine_punti.TermovalorizzatoreBorgoforteActivity
import com.example.freakyapp.pagine_punti.CentraleIdroelettricaIsolaSerafiniActivity
import com.example.freakyapp.pagine_punti.ImpiantoIdrovoroConsorzioMuzioActivity
import com.example.freakyapp.pagine_punti.FinestraSulPoActivity
import com.example.freakyapp.pagine_punti.AgriturismoBoschiCelatiActivity
import com.example.freakyapp.pagine_punti.TrattoriaMagatonActivity
import com.example.freakyapp.pagine_punti.TrattoriaTonoliActivity
import com.example.freakyapp.pagine_punti.TrattoriaDeiViaggiatoriActivity
import com.example.freakyapp.pagine_punti.TrattoriaChaletSulPoActivity
import com.example.freakyapp.pagine_punti.TanaDiRoncaroloActivity
import com.example.freakyapp.pagine_punti.TrattoriaIlMilanistaActivity
import com.example.freakyapp.pagine_punti.DistributoreAcquaMortizzaActivity
import com.example.freakyapp.pagine_punti.ImpiantoIdrovoroArmalungaActivity


class LocationService : Service() {

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var locationClient: LocationClient
    private var proximityNotifiedStazionePC = false
    private var proximityNotifiedTorrioneFodesta = false
    private var proximityNotifiedExCentraleEmilia = false
    private var proximityNotifiedPonteDelleCeramiche = false
    private var proximityNotifiedPonteFerroviario = false
    private var proximityNotifiedPonteSanRocco = false
    private var proximityNotifiedPonteAutostrada = false
    private var proximityNotifiedPonteAV = false
    private var proximityNotifiedNinoBixio = false
    private var proximityNotifiedIsolottoMaggi = false
    private var proximityNotifiedImpiantoIdrovoroFinarda = false
    private var proximityNotifiedCentraleCaorso = false
    private var proximityNotifiedFontanellaRoncarolo = false
    private var proximityNotifiedAreaSostaSNazzaro = false
    private var proximityNotifiedPonteSNazzaro = false
    private var proximityNotifiedPassaggioSuStradaFossadello = false
    private var proximityNotifiedPartenza = false
    private var proximityNotifiedCiclabilePonteSRocco = false
    private var proximityNotifiedDiscesaDalPonte = false
    private var proximityNotifiedIsolaSerafini = false
    private var proximityNotifiedOasiNaturalisticaPinedo = false
    private var proximityNotifiedCentraleTermoelettricaLevante = false
    private var proximityNotifiedLeap = false
    private var proximityNotifiedImpiantoIdrovoroBorgoforte = false
    private var proximityNotifiedDepuratoreBorgoforte = false
    private var proximityNotifiedTermovalorizzatoreBorgoforte = false
    private var proximityNotifiedCentraleIdroelettricaIsolaSerafini = false
    private var proximityNotifiedImpiantoIdrovoroArmalunga = false
    private var proximityNotifiedImpiantoIdrovoroConsorzioMuzio = false
    private var proximityNotifiedFinestraSulPo = false
    private var proximityNotifiedAgriturismoBoschiCelati = false
    private var proximityNotifiedTrattoriaMagaton = false
    private var proximityNotifiedTrattoriaTonoli = false
    private var proximityNotifiedTrattoriaDeiViaggiatori = false
    private var proximityNotifiedTrattoriaChaletSulPo = false
    private var proximityNotifiedTanaDiRoncarolo = false
    private var proximityNotifiedTrattoriaIlMilanista = false
    private var proximityNotifiedTrattoriaCattivelli = false
    private var proximityNotifiedDistributoreAcquaMortizza = false


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        locationClient = DefaultLocationClient(
            applicationContext,
            LocationServices.getFusedLocationProviderClient(applicationContext)
        )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> start()
            ACTION_STOP -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Creazione del canale di notifica (necessario per Android O e successivi)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "location_channel",
                "Location Notifications",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                setSound(null, null)
                enableVibration(false)
            }
            notificationManager.createNotificationChannel(channel)
        }

        locationClient
            .getLocationUpdates(interval = 10000L)
            .catch { e -> e.printStackTrace() }
            .onEach { location ->
                val lat = location.latitude
                val long = location.longitude

                // Aggiorna la notifica con le coordinate correnti
                val updatedNotification = NotificationCompat.Builder(this, "location_channel")
                    .setContentTitle("Tracking location...")
                    .setContentText("Location: ($lat, $long)")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setOngoing(true)
                    .setSound(null) // Silenziosa
                    .setVibrate(null)
                    .build()

                notificationManager.notify(1, updatedNotification)

                // Controlla la prossimità a determinati punti
                checkProximity(location)
            }
            .launchIn(serviceScope)

        // Avvia il servizio in primo piano con una notifica iniziale
        startForeground(
            1, NotificationCompat.Builder(this, "location_channel")
                .setContentTitle("Tracking location...")
                .setContentText("Location: null")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setOngoing(true)
                .setSound(null)
                .setVibrate(null)
                .build()
        )
    }

    private fun stop() {
        stopForeground(STOP_FOREGROUND_DETACH)
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    private fun checkProximity(location: Location) {
        //Storia
        val stazionePC = Pair(45.051949, 9.706057)  // Stazione PC
        val torrioneFodesta = Pair(45.05640, 9.70219)  // Torrione Fodesta
        val exCentraleEmilia = Pair(45.0566477, 9.7073399)  // Ex Centrale Emilia (ANCHE IN ECONOMIA CIRCOLARE)
        val ponteDelleCeramiche = Pair(45.06465244770296, 9.874184362634118)  // Ponte delle Ceramiche
        val ponteFerroviario = Pair(45.060207, 9.705384)  // Ponte ferroviario
        val ponteSanRocco = Pair(45.061327, 9.703623)  // Ponte San Rocco
        val ponteAutostrada = Pair(45.065589, 9.734353)  // Ponte autostrada
        val ponteAV = Pair(45.07793231541073, 9.745598741245159)  // Ponte AV
        val ninoBixio = Pair(45.057645230252874, 9.707142230260848)  // Nino Bixio
        val isolottoMaggi = Pair(45.05784320256016, 9.713248336552905)  // Isolotto Maggi
        val centraleCaorso = Pair(45.07208510840803, 9.86782820916427)  // Centrale Caorso

        // Viabilità - mobilità ciclabile
        val fontanellaRoncarolo = Pair(45.0655013, 9.8390417)  // Fontanella Roncarolo (ANCHE IN TURISMO)
        val areaSostaSNazzaro = Pair(45.0768997, 9.8943338)  // Area sosta S. Nazzaro (ANCHE IN TURISMO)
        val ponteSNazzaro = Pair(45.081887347122866, 9.898561404386227)  // Ponte S. Nazzaro
        val passaggioSuStradaFossadello = Pair(45.081887347122866, 9.898561404386227)  // Passaggio su strada Fossadello
        val partenza = Pair(45.055930, 9.702823)  // Partenza
        val ciclabilePonteSRocco = Pair(45.055930, 9.702823)  // Ciclabile Ponte S. Rocco
        val discesaDalPonte = Pair(45.058143, 9.700901)  // Discesa dal ponte

        // Paesaggio naturale e biodiversità
        val isolaSerafini = Pair(45.09332194310006, 9.904885527112402)  // Isola Serafini
        val oasiNaturalisticaPinedo = Pair(45.084375202603546, 9.865746896312627)  // Oasi naturalistica dell'Isola del Pinedo

        // Economia circolare ed energia
        val impiantoIdrovoroFinarda = Pair(45.055291, 9.714616)  // Impianto idrovoro Finarda
        val centraleTermoelettricaLevante = Pair(45.05592174155956, 9.707834527001006)  // Centrale termoelettrica ex "Levante"
        val leap = Pair(45.058188224501244, 9.705801096960299)  // LEAP
        val impiantoIdrovoroBorgoforte = Pair(45.05750958022169, 9.733062031555836)  // Impianto idrovoro Borgoforte
        val depuratoreBorgoforte = Pair(45.05949270337371, 9.732816388159177)  // Depuratore Borgoforte
        val termovalorizzatoreBorgoforte = Pair(45.05949270337371, 9.732816388159177)  // Termovalorizzatore Borgoforte
        val centraleIdroelettricaIsolaSerafini = Pair(45.09478508718558, 9.904594069179499)  // Centrale idroelettrica Isola Serafini
        val impiantoIdrovoroArmalunga = Pair(45.05521654110569, 9.800781841884934) //Impianto idrovoro di Armalunga
        val impiantoIdrovoroConsorzioMuzio = Pair(45.105883386456426, 9.736189359512233)  // Impianto idrovoro del Consorzio Muzio

        // Turismo
        val finestraSulPo = Pair(45.0760107, 9.8925903)  // La finestra sul Po
        val agriturismoBoschiCelati = Pair(45.04932571085476, 9.81132763801647)  // Agriturismo Boschi Celati
        val trattoriaMagaton = Pair(45.0586710, 9.8346721)  // Trattoria Magaton
        val trattoriaTonoli = Pair(45.065326833971575, 9.840337259324594)  // Trattoria Tonoli
        val trattoriaDeiViaggiatori = Pair(45.100418177127146, 9.793586156270205)  // Trattoria dei viaggiatori
        val trattoriaChaletSulPo = Pair(45.1130937, 9.7596986)  // Trattoria Chalet sul Po
        val tanaDiRoncarolo = Pair(45.0655449, 9.8379189)  // La tana di Roncarolo
        val trattoriaIlMilanista = Pair(45.07589139606873, 9.895138352448015)  // Trattoria Il Milanista
        val distributoreAcquaMortizza = Pair(45.07815930003141, 9.756850391)  // Distributore d'acqua Mortizza
        val trattoriaCattivelli = Pair(45.09687901677327, 9.905943726049475) //Trattoria Cattivelli

        val proximityThreshold = 0.00016875 // Tolleranza per la distanza (in gradi lat-long, distanza desiderata(metri)/distanza per grado(111000 metri)

        val lat = location.latitude
        val long = location.longitude

        when {
            isWithinRange(lat, long, stazionePC.first, stazionePC.second, proximityThreshold) && !proximityNotifiedStazionePC -> {
                proximityNotifiedStazionePC = true
                sendNotification(
                    title = "Sei vicino alla Stazione PC",
                    message = "Tocca per aprire",
                    targetActivity = StazionePCActivity::class.java
                )
            }
            isWithinRange(lat, long, torrioneFodesta.first, torrioneFodesta.second, proximityThreshold) && !proximityNotifiedTorrioneFodesta -> {
                proximityNotifiedTorrioneFodesta = true
                sendNotification(
                    title = "Sei vicino a Torrione Fodesta",
                    message = "Tocca per aprire",
                    targetActivity = TorrioneFodestaActivity::class.java
                )
            }
            isWithinRange(lat, long, exCentraleEmilia.first, exCentraleEmilia.second, proximityThreshold) && !proximityNotifiedExCentraleEmilia -> {
                proximityNotifiedExCentraleEmilia = true
                sendNotification(
                    title = "Sei vicino all'Ex Centrale Emilia",
                    message = "Tocca per aprire",
                    targetActivity = ExCentraleEmiliaActivity::class.java
                )
            }
            isWithinRange(lat, long, ponteDelleCeramiche.first, ponteDelleCeramiche.second, proximityThreshold) && !proximityNotifiedPonteDelleCeramiche -> {
                proximityNotifiedPonteDelleCeramiche = true
                sendNotification(
                    title = "Sei vicino al Ponte delle Ceramiche",
                    message = "Tocca per aprire",
                    targetActivity = PonteDelleCeramicheActivity::class.java
                )
            }
            isWithinRange(lat, long, ponteFerroviario.first, ponteFerroviario.second, proximityThreshold) && !proximityNotifiedPonteFerroviario -> {
                proximityNotifiedPonteFerroviario = true
                sendNotification(
                    title = "Sei vicino al Ponte ferroviario",
                    message = "Tocca per aprire",
                    targetActivity = PonteFerroviarioActivity::class.java
                )
            }
            isWithinRange(lat, long, ponteSanRocco.first, ponteSanRocco.second, proximityThreshold) && !proximityNotifiedPonteSanRocco -> {
                proximityNotifiedPonteSanRocco = true
                sendNotification(
                    title = "Sei vicino al Ponte San Rocco",
                    message = "Tocca per aprire",
                    targetActivity = PonteSanRoccoActivity::class.java
                )
            }
            isWithinRange(lat, long, ponteAutostrada.first, ponteAutostrada.second, proximityThreshold) && !proximityNotifiedPonteAutostrada -> {
                proximityNotifiedPonteAutostrada = true
                sendNotification(
                    title = "Sei vicino al Ponte autostrada",
                    message = "Tocca per aprire",
                    targetActivity = PonteAutostradaActivity::class.java
                )
            }
            isWithinRange(lat, long, ponteAV.first, ponteAV.second, proximityThreshold) && !proximityNotifiedPonteAV -> {
                proximityNotifiedPonteAV = true
                sendNotification(
                    title = "Sei vicino al Ponte AV",
                    message = "Tocca per aprire",
                    targetActivity = PonteAVActivity::class.java
                )
            }
            isWithinRange(lat, long, ninoBixio.first, ninoBixio.second, proximityThreshold) && !proximityNotifiedNinoBixio -> {
                proximityNotifiedNinoBixio = true
                sendNotification(
                    title = "Sei vicino a Nino Bixio",
                    message = "Tocca per aprire",
                    targetActivity = NinoBixioActivity::class.java
                )
            }
            isWithinRange(lat, long, isolottoMaggi.first, isolottoMaggi.second, proximityThreshold) && !proximityNotifiedIsolottoMaggi -> {
                proximityNotifiedIsolottoMaggi = true
                sendNotification(
                    title = "Sei vicino a Isolotto Maggi",
                    message = "Tocca per aprire",
                    targetActivity = IsolottoMaggiActivity::class.java
                )
            }
            isWithinRange(lat, long, impiantoIdrovoroFinarda.first, impiantoIdrovoroFinarda.second, proximityThreshold) && !proximityNotifiedImpiantoIdrovoroFinarda -> {
                proximityNotifiedImpiantoIdrovoroFinarda = true
                sendNotification(
                    title = "Sei vicino all'Impianto idrovoro Finarda",
                    message = "Tocca per aprire",
                    targetActivity = ImpiantoIdrovoroFinardaActivity::class.java
                )
            }
            isWithinRange(lat, long, centraleCaorso.first, centraleCaorso.second, proximityThreshold) && !proximityNotifiedCentraleCaorso -> {
                proximityNotifiedCentraleCaorso = true
                sendNotification(
                    title = "Sei vicino alla Centrale Caorso",
                    message = "Tocca per aprire",
                    targetActivity = CentraleCaorsoActivity::class.java
                )
            }
            isWithinRange(lat, long, fontanellaRoncarolo.first, fontanellaRoncarolo.second, proximityThreshold) && !proximityNotifiedFontanellaRoncarolo -> {
                proximityNotifiedFontanellaRoncarolo = true
                sendNotification(
                    title = "Sei vicino alla Fontanella Roncarolo",
                    message = "Tocca per aprire",
                    targetActivity = FontanellaRoncaroloActivity::class.java
                )
            }
            isWithinRange(lat, long, areaSostaSNazzaro.first, areaSostaSNazzaro.second, proximityThreshold) && !proximityNotifiedAreaSostaSNazzaro -> {
                proximityNotifiedAreaSostaSNazzaro = true
                sendNotification(
                    title = "Sei vicino all'Area sosta S. Nazzaro",
                    message = "Tocca per aprire",
                    targetActivity = AreaSostaSNazzaroActivity::class.java
                )
            }
            isWithinRange(lat, long, ponteSNazzaro.first, ponteSNazzaro.second, proximityThreshold) && !proximityNotifiedPonteSNazzaro -> {
                proximityNotifiedPonteSNazzaro = true
                sendNotification(
                    title = "Sei vicino al Ponte S. Nazzaro",
                    message = "Tocca per aprire",
                    targetActivity = PonteSNazzaroActivity::class.java
                )
            }
            isWithinRange(lat, long, passaggioSuStradaFossadello.first, passaggioSuStradaFossadello.second, proximityThreshold) && !proximityNotifiedPassaggioSuStradaFossadello -> {
                proximityNotifiedPassaggioSuStradaFossadello = true
                sendNotification(
                    title = "Sei vicino al Passaggio su strada Fossadello",
                    message = "Tocca per aprire",
                    targetActivity = PassaggioSuStradaFossadelloActivity::class.java
                )
            }
            isWithinRange(lat, long, partenza.first, partenza.second, proximityThreshold) && !proximityNotifiedPartenza -> {
                proximityNotifiedPartenza = true
                sendNotification(
                    title = "Sei vicino alla Partenza",
                    message = "Tocca per aprire",
                    targetActivity = PartenzaActivity::class.java
                )
            }
            isWithinRange(lat, long, ciclabilePonteSRocco.first, ciclabilePonteSRocco.second, proximityThreshold) && !proximityNotifiedCiclabilePonteSRocco -> {
                proximityNotifiedCiclabilePonteSRocco = true
                sendNotification(
                    title = "Sei vicino alla Ciclabile Ponte S. Rocco",
                    message = "Tocca per aprire",
                    targetActivity = CiclabilePonteSRoccoActivity::class.java
                )
            }
            isWithinRange(lat, long, discesaDalPonte.first, discesaDalPonte.second, proximityThreshold) && !proximityNotifiedDiscesaDalPonte -> {
                proximityNotifiedDiscesaDalPonte = true
                sendNotification(
                    title = "Sei vicino alla Discesa dal ponte",
                    message = "Tocca per aprire",
                    targetActivity = DiscesaDalPonteActivity::class.java
                )
            }
            isWithinRange(lat, long, isolaSerafini.first, isolaSerafini.second, proximityThreshold) && !proximityNotifiedIsolaSerafini -> {
                proximityNotifiedIsolaSerafini = true
                sendNotification(
                    title = "Sei vicino all'Isola Serafini",
                    message = "Tocca per aprire",
                    targetActivity = IsolaSerafiniActivity::class.java
                )
            }
            isWithinRange(lat, long, oasiNaturalisticaPinedo.first, oasiNaturalisticaPinedo.second, proximityThreshold) && !proximityNotifiedOasiNaturalisticaPinedo -> {
                proximityNotifiedOasiNaturalisticaPinedo = true
                sendNotification(
                    title = "Sei vicino all'Oasi naturalistica dell'Isola del Pinedo",
                    message = "Tocca per aprire",
                    targetActivity = OasiNaturalisticaPinedoActivity::class.java
                )
            }
            isWithinRange(lat, long, centraleTermoelettricaLevante.first, centraleTermoelettricaLevante.second, proximityThreshold) && !proximityNotifiedCentraleTermoelettricaLevante -> {
                proximityNotifiedCentraleTermoelettricaLevante = true
                sendNotification(
                    title = "Sei vicino alla Centrale termoelettrica ex 'Levante'",
                    message = "Tocca per aprire",
                    targetActivity = CentraleTermoelettricaLevanteActivity::class.java
                )
            }
            isWithinRange(lat, long, leap.first, leap.second, proximityThreshold) && !proximityNotifiedLeap -> {
                proximityNotifiedLeap = true
                sendNotification(
                    title = "Sei vicino al LEAP",
                    message = "Tocca per aprire",
                    targetActivity = LeapActivity::class.java
                )
            }
            isWithinRange(lat, long, impiantoIdrovoroBorgoforte.first, impiantoIdrovoroBorgoforte.second, proximityThreshold) && !proximityNotifiedImpiantoIdrovoroBorgoforte -> {
                proximityNotifiedImpiantoIdrovoroBorgoforte = true
                sendNotification(
                    title = "Sei vicino all'Impianto idrovoro Borgoforte",
                    message = "Tocca per aprire",
                    targetActivity = ImpiantoIdrovoroBorgoforteActivity::class.java
                )
            }
            isWithinRange(lat, long, depuratoreBorgoforte.first, depuratoreBorgoforte.second, proximityThreshold) && !proximityNotifiedDepuratoreBorgoforte -> {
                proximityNotifiedDepuratoreBorgoforte = true
                sendNotification(
                    title = "Sei vicino al Depuratore Borgoforte",
                    message = "Tocca per aprire",
                    targetActivity = DepuratoreBorgoforteActivity::class.java
                )
            }
            isWithinRange(lat, long, termovalorizzatoreBorgoforte.first, termovalorizzatoreBorgoforte.second, proximityThreshold) && !proximityNotifiedTermovalorizzatoreBorgoforte -> {
                proximityNotifiedTermovalorizzatoreBorgoforte = true
                sendNotification(
                    title = "Sei vicino al Termovalorizzatore Borgoforte",
                    message = "Tocca per aprire",
                    targetActivity = TermovalorizzatoreBorgoforteActivity::class.java
                )
            }
            isWithinRange(lat, long, centraleIdroelettricaIsolaSerafini.first, centraleIdroelettricaIsolaSerafini.second, proximityThreshold) && !proximityNotifiedCentraleIdroelettricaIsolaSerafini -> {
                proximityNotifiedCentraleIdroelettricaIsolaSerafini = true
                sendNotification(
                    title = "Sei vicino alla Centrale idroelettrica Isola Serafini",
                    message = "Tocca per aprire",
                    targetActivity = CentraleIdroelettricaIsolaSerafiniActivity::class.java
                )
            }
            isWithinRange(lat, long, impiantoIdrovoroArmalunga.first, impiantoIdrovoroArmalunga.second, proximityThreshold) && !proximityNotifiedImpiantoIdrovoroArmalunga -> {
                proximityNotifiedImpiantoIdrovoroArmalunga = true
                sendNotification(
                    title = "Sei vicino all'impianto idrovoro di Armalunga",
                    message = "Tocca per aprire",
                    targetActivity = ImpiantoIdrovoroArmalungaActivity::class.java
                )
            }
            isWithinRange(lat, long, impiantoIdrovoroConsorzioMuzio.first, impiantoIdrovoroConsorzioMuzio.second, proximityThreshold) && !proximityNotifiedImpiantoIdrovoroConsorzioMuzio -> {
                proximityNotifiedImpiantoIdrovoroConsorzioMuzio = true
                sendNotification(
                    title = "Sei vicino all'Impianto idrovoro del Consorzio Muzio",
                    message = "Tocca per aprire",
                    targetActivity = ImpiantoIdrovoroConsorzioMuzioActivity::class.java
                )
            }
            isWithinRange(lat, long, finestraSulPo.first, finestraSulPo.second, proximityThreshold) && !proximityNotifiedFinestraSulPo -> {
                proximityNotifiedFinestraSulPo = true
                sendNotification(
                    title = "Sei vicino alla Finestra sul Po",
                    message = "Tocca per aprire",
                    targetActivity = FinestraSulPoActivity::class.java
                )
            }
            isWithinRange(lat, long, agriturismoBoschiCelati.first, agriturismoBoschiCelati.second, proximityThreshold) && !proximityNotifiedAgriturismoBoschiCelati -> {
                proximityNotifiedAgriturismoBoschiCelati = true
                sendNotification(
                    title = "Sei vicino all'Agriturismo Boschi Celati",
                    message = "Tocca per aprire",
                    targetActivity = AgriturismoBoschiCelatiActivity::class.java
                )
            }
            isWithinRange(lat, long, trattoriaMagaton.first, trattoriaMagaton.second, proximityThreshold) && !proximityNotifiedTrattoriaMagaton -> {
                proximityNotifiedTrattoriaMagaton = true
                sendNotification(
                    title = "Sei vicino alla Trattoria Magaton",
                    message = "Tocca per aprire",
                    targetActivity = TrattoriaMagatonActivity::class.java
                )
            }
            isWithinRange(lat, long, trattoriaTonoli.first, trattoriaTonoli.second, proximityThreshold) && !proximityNotifiedTrattoriaTonoli -> {
                proximityNotifiedTrattoriaTonoli = true
                sendNotification(
                    title = "Sei vicino alla Trattoria Tonoli",
                    message = "Tocca per aprire",
                    targetActivity = TrattoriaTonoliActivity::class.java
                )
            }
            isWithinRange(lat, long, trattoriaDeiViaggiatori.first, trattoriaDeiViaggiatori.second, proximityThreshold) && !proximityNotifiedTrattoriaDeiViaggiatori -> {
                proximityNotifiedTrattoriaDeiViaggiatori = true
                sendNotification(
                    title = "Sei vicino alla Trattoria dei Viaggiatori",
                    message = "Tocca per aprire",
                    targetActivity = TrattoriaDeiViaggiatoriActivity::class.java
                )
            }
            isWithinRange(lat, long, trattoriaChaletSulPo.first, trattoriaChaletSulPo.second, proximityThreshold) && !proximityNotifiedTrattoriaChaletSulPo -> {
                proximityNotifiedTrattoriaChaletSulPo = true
                sendNotification(
                    title = "Sei vicino alla Trattoria Chalet sul Po",
                    message = "Tocca per aprire",
                    targetActivity = TrattoriaChaletSulPoActivity::class.java
                )
            }
            isWithinRange(lat, long, tanaDiRoncarolo.first, tanaDiRoncarolo.second, proximityThreshold) && !proximityNotifiedTanaDiRoncarolo -> {
                proximityNotifiedTanaDiRoncarolo = true
                sendNotification(
                    title = "Sei vicino alla Tana di Roncarolo",
                    message = "Tocca per aprire",
                    targetActivity = TanaDiRoncaroloActivity::class.java
                )
            }
            isWithinRange(lat, long, trattoriaIlMilanista.first, trattoriaIlMilanista.second, proximityThreshold) && !proximityNotifiedTrattoriaIlMilanista -> {
                proximityNotifiedTrattoriaIlMilanista = true
                sendNotification(
                    title = "Sei vicino alla Trattoria Il Milanista",
                    message = "Tocca per aprire",
                    targetActivity = TrattoriaIlMilanistaActivity::class.java
                )
            }
            isWithinRange(lat, long, distributoreAcquaMortizza.first, distributoreAcquaMortizza.second, proximityThreshold) && !proximityNotifiedDistributoreAcquaMortizza -> {
                proximityNotifiedDistributoreAcquaMortizza = true
                sendNotification(
                    title = "Sei vicino al Distributore d'acqua Mortizza",
                    message = "Tocca per aprire",
                    targetActivity = DistributoreAcquaMortizzaActivity::class.java
                )
            }

            !isWithinRange(lat, long, stazionePC.first, stazionePC.second, proximityThreshold) -> proximityNotifiedStazionePC = false
            !isWithinRange(lat, long, torrioneFodesta.first, torrioneFodesta.second, proximityThreshold) -> proximityNotifiedTorrioneFodesta = false
            !isWithinRange(lat, long, exCentraleEmilia.first, exCentraleEmilia.second, proximityThreshold) -> proximityNotifiedExCentraleEmilia = false
            !isWithinRange(lat, long, ponteDelleCeramiche.first, ponteDelleCeramiche.second, proximityThreshold) -> proximityNotifiedPonteDelleCeramiche = false
            !isWithinRange(lat, long, ponteFerroviario.first, ponteFerroviario.second, proximityThreshold) -> proximityNotifiedPonteFerroviario = false
            !isWithinRange(lat, long, ponteSanRocco.first, ponteSanRocco.second, proximityThreshold) -> proximityNotifiedPonteSanRocco = false
            !isWithinRange(lat, long, ponteAutostrada.first, ponteAutostrada.second, proximityThreshold) -> proximityNotifiedPonteAutostrada = false
            !isWithinRange(lat, long, ponteAV.first, ponteAV.second, proximityThreshold) -> proximityNotifiedPonteAV = false
            !isWithinRange(lat, long, ninoBixio.first, ninoBixio.second, proximityThreshold) -> proximityNotifiedNinoBixio = false
            !isWithinRange(lat, long, isolottoMaggi.first, isolottoMaggi.second, proximityThreshold) -> proximityNotifiedIsolottoMaggi = false
            !isWithinRange(lat, long, impiantoIdrovoroFinarda.first, impiantoIdrovoroFinarda.second, proximityThreshold) -> proximityNotifiedImpiantoIdrovoroFinarda = false
            !isWithinRange(lat, long, centraleCaorso.first, centraleCaorso.second, proximityThreshold) -> proximityNotifiedCentraleCaorso = false
            !isWithinRange(lat, long, fontanellaRoncarolo.first, fontanellaRoncarolo.second, proximityThreshold) -> proximityNotifiedFontanellaRoncarolo = false
            !isWithinRange(lat, long, areaSostaSNazzaro.first, areaSostaSNazzaro.second, proximityThreshold) -> proximityNotifiedAreaSostaSNazzaro = false
            !isWithinRange(lat, long, ponteSNazzaro.first, ponteSNazzaro.second, proximityThreshold) -> proximityNotifiedPonteSNazzaro = false
            !isWithinRange(lat, long, passaggioSuStradaFossadello.first, passaggioSuStradaFossadello.second, proximityThreshold) -> proximityNotifiedPassaggioSuStradaFossadello = false
            !isWithinRange(lat, long, partenza.first, partenza.second, proximityThreshold) -> proximityNotifiedPartenza = false
            !isWithinRange(lat, long, ciclabilePonteSRocco.first, ciclabilePonteSRocco.second, proximityThreshold) -> proximityNotifiedCiclabilePonteSRocco = false
            !isWithinRange(lat, long, discesaDalPonte.first, discesaDalPonte.second, proximityThreshold) -> proximityNotifiedDiscesaDalPonte = false
            !isWithinRange(lat, long, isolaSerafini.first, isolaSerafini.second, proximityThreshold) -> proximityNotifiedIsolaSerafini = false
            !isWithinRange(lat, long, oasiNaturalisticaPinedo.first, oasiNaturalisticaPinedo.second, proximityThreshold) -> proximityNotifiedOasiNaturalisticaPinedo = false
            !isWithinRange(lat, long, centraleTermoelettricaLevante.first, centraleTermoelettricaLevante.second, proximityThreshold) -> proximityNotifiedCentraleTermoelettricaLevante = false
            !isWithinRange(lat, long, leap.first, leap.second, proximityThreshold) -> proximityNotifiedLeap = false
            !isWithinRange(lat, long, impiantoIdrovoroBorgoforte.first, impiantoIdrovoroBorgoforte.second, proximityThreshold) -> proximityNotifiedImpiantoIdrovoroBorgoforte = false
            !isWithinRange(lat, long, depuratoreBorgoforte.first, depuratoreBorgoforte.second, proximityThreshold) -> proximityNotifiedDepuratoreBorgoforte = false
            !isWithinRange(lat, long, termovalorizzatoreBorgoforte.first, termovalorizzatoreBorgoforte.second, proximityThreshold) -> proximityNotifiedTermovalorizzatoreBorgoforte = false
            !isWithinRange(lat, long, centraleIdroelettricaIsolaSerafini.first, centraleIdroelettricaIsolaSerafini.second, proximityThreshold) -> proximityNotifiedCentraleIdroelettricaIsolaSerafini = false
            !isWithinRange(lat, long, impiantoIdrovoroArmalunga.first, impiantoIdrovoroArmalunga.second, proximityThreshold) -> proximityNotifiedImpiantoIdrovoroArmalunga = false
            !isWithinRange(lat, long, impiantoIdrovoroConsorzioMuzio.first, impiantoIdrovoroConsorzioMuzio.second, proximityThreshold) -> proximityNotifiedImpiantoIdrovoroConsorzioMuzio = false
            !isWithinRange(lat, long, finestraSulPo.first, finestraSulPo.second, proximityThreshold) -> proximityNotifiedFinestraSulPo = false
            !isWithinRange(lat, long, agriturismoBoschiCelati.first, agriturismoBoschiCelati.second, proximityThreshold) -> proximityNotifiedAgriturismoBoschiCelati = false
            !isWithinRange(lat, long, trattoriaMagaton.first, trattoriaMagaton.second, proximityThreshold) -> proximityNotifiedTrattoriaMagaton = false
            !isWithinRange(lat, long, trattoriaTonoli.first, trattoriaTonoli.second, proximityThreshold) -> proximityNotifiedTrattoriaTonoli = false
            !isWithinRange(lat, long, trattoriaDeiViaggiatori.first, trattoriaDeiViaggiatori.second, proximityThreshold) -> proximityNotifiedTrattoriaDeiViaggiatori = false
            !isWithinRange(lat, long, trattoriaChaletSulPo.first, trattoriaChaletSulPo.second, proximityThreshold) -> proximityNotifiedTrattoriaChaletSulPo = false
            !isWithinRange(lat, long, tanaDiRoncarolo.first, tanaDiRoncarolo.second, proximityThreshold) -> proximityNotifiedTanaDiRoncarolo = false
            !isWithinRange(lat, long, trattoriaIlMilanista.first, trattoriaIlMilanista.second, proximityThreshold) -> proximityNotifiedTrattoriaIlMilanista = false
            !isWithinRange(lat, long, distributoreAcquaMortizza.first, distributoreAcquaMortizza.second, proximityThreshold) -> proximityNotifiedDistributoreAcquaMortizza = false
        }
    }

    private fun isWithinRange(
        lat1: Double, long1: Double, lat2: Double, long2: Double, threshold: Double
    ): Boolean {
        val distanceLat = Math.abs(lat1 - lat2)
        val distanceLong = Math.abs(long1 - long2)
        return distanceLat < threshold && distanceLong < threshold
    }

    private fun sendNotification(title: String, message: String, targetActivity: Class<*>) {
        val intent = Intent(this, targetActivity).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        // Usa un requestCode unico basato sull'hash di titolo + messaggio
        val requestCode = (title + message).hashCode()

        val pendingIntent = PendingIntent.getActivity(
            this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, "location_channel")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify((title + message).hashCode(), notification)
    }

    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
    }
}

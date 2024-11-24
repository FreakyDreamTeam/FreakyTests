import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.freakyapp.R
import com.example.freakyapp.pagine_punti.AgriturismoBoschiCelatiActivity
import com.example.freakyapp.pagine_punti.AreaSostaSNazzaroActivity
import com.example.freakyapp.pagine_punti.CentraleCaorsoActivity
import com.example.freakyapp.pagine_punti.CentraleIdroelettricaIsolaSerafiniActivity
import com.example.freakyapp.pagine_punti.CentraleTermoelettricaLevanteActivity
import com.example.freakyapp.pagine_punti.CiclabilePonteSRoccoActivity
import com.example.freakyapp.pagine_punti.DepuratoreBorgoforteActivity
import com.example.freakyapp.pagine_punti.DiscesaDalPonteActivity
import com.example.freakyapp.pagine_punti.DistributoreAcquaMortizzaActivity
import com.example.freakyapp.pagine_punti.ElementiClimaticiActivity
import com.example.freakyapp.pagine_punti.ExCentraleEmiliaActivity
import com.example.freakyapp.pagine_punti.FaunaActivity
import com.example.freakyapp.pagine_punti.FinestraSulPoActivity
import com.example.freakyapp.pagine_punti.FloraActivity
import com.example.freakyapp.pagine_punti.FontanellaRoncaroloActivity
import com.example.freakyapp.pagine_punti.ImpiantoIdrovoroArmalungaActivity
import com.example.freakyapp.pagine_punti.ImpiantoIdrovoroConsorzioMuzioActivity
import com.example.freakyapp.pagine_punti.ImpiantoIdrovoroFinardaActivity
import com.example.freakyapp.pagine_punti.IsolaSerafiniActivity
import com.example.freakyapp.pagine_punti.IsolottoMaggiActivity
import com.example.freakyapp.pagine_punti.LeapActivity
import com.example.freakyapp.pagine_punti.NinoBixioActivity
import com.example.freakyapp.pagine_punti.OasiNaturalisticaPinedoActivity
import com.example.freakyapp.pagine_punti.PaesaggioFluvialeActivity
import com.example.freakyapp.pagine_punti.PassaggioSuStradaFossadelloActivity
import com.example.freakyapp.pagine_punti.PonteAVActivity
import com.example.freakyapp.pagine_punti.PonteAutostradaActivity
import com.example.freakyapp.pagine_punti.PonteDelleCeramicheActivity
import com.example.freakyapp.pagine_punti.PonteFerroviarioActivity
import com.example.freakyapp.pagine_punti.PonteSNazzaroActivity
import com.example.freakyapp.pagine_punti.PonteSanRoccoActivity
import com.example.freakyapp.pagine_punti.StazionePCActivity
import com.example.freakyapp.pagine_punti.TanaDiRoncaroloActivity
import com.example.freakyapp.pagine_punti.TermovalorizzatoreBorgoforteActivity
import com.example.freakyapp.pagine_punti.TorrioneFodestaActivity
import com.example.freakyapp.pagine_punti.TrattoriaCattivelliActivity
import com.example.freakyapp.pagine_punti.TrattoriaChaletSulPoActivity
import com.example.freakyapp.pagine_punti.TrattoriaDeiViaggiatoriActivity
import com.example.freakyapp.pagine_punti.TrattoriaIlMilanistaActivity
import com.example.freakyapp.pagine_punti.TrattoriaMagatonActivity
import com.example.freakyapp.pagine_punti.TrattoriaTonoliActivity


@Composable
fun Sections() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "sections") {
        composable("sections") { SectionContent(navController) }
        composable("section1") { SectionPaesaggio() }
        composable("section2") { SectionEconomia() }
        composable("section3") { SectionStoria() }
        composable("section4") { SectionViabilità() }
        composable("section5") { SectionTurismo() }
    }
}


@Composable
fun SectionContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ) {
        SectionItem(
            navController = navController,
            imageRes = R.drawable.paesaggio2,
            title = "Paesaggio",
            description = "Tra sponda piacentina e sponda lombarda, le tranquille acque del fiume si snodano tra ampie pianure, argini fioriti...",
            destination = "section1"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.caorso_centrale,
            title = "Economia",
            description = "Lungo la ciclovia del Po, i ciclisti possono osservare diversi esempi di produzione energetica sostenibile e differenti impieghi della tecnologia...",
            destination = "section2"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.isolotto_maggi,
            title = "Storia",
            description = "Lungo la ciclovia del Po, si possono incontrare interessanti elementi storici e architettonici. I caratteristici borghi, con le loro chiese e i...",
            destination = "section3"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.ponteav,
            title = "Viabilità",
            description = "La ciclovia del Po in territorio piacentino e sulla sponda lombarda offre una viabilità ben strutturata, con percorsi dedicati e segnaletica chiara che garantiscono...",
            destination = "section4"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.natura,
            title = "Turismo",
            description = "Percorrendo la ciclovia del Po, i visitatori possono esplorare borghi storici, degustare vini locali e scoprire le tradizioni culinarie della...",
            destination = "section5"
        )
    }
}


@Composable
fun SectionItem(
    navController: NavController,
    imageRes: Int,
    title: String,
    description: String,
    destination: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth() // Immagini ora occupano tutta la larghezza disponibile
                .aspectRatio(3f / 2f) // Modifica il rapporto d'aspetto a 3:2 per ingrandirle
                .clip(RoundedCornerShape(16.dp))// Angoli molto arrotondati (32.dp)
                .clickable {
                    navController.navigate(destination) // Navigazione verso la pagina specifica
                },
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(8.dp)) // Spazio tra immagine e testo

        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Text(
            text = description,
            fontSize = 16.sp
        )
    }
}

@Composable
fun SectionItemActivity(
    imageRes: Int,
    title: String,
    description: String,
    targetActivity: Class<*>
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth() // Immagini ora occupano tutta la larghezza disponibile
                .aspectRatio(3f / 2f) // Modifica il rapporto d'aspetto a 3:2 per ingrandirle
                .clip(RoundedCornerShape(16.dp))// Angoli molto arrotondati (32.dp)
                .clickable {
                    val intent =
                        Intent(context, targetActivity) // Crea l'intento per avviare l'activity
                    context.startActivity(intent) // Avvia l'activity
                },
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(8.dp)) // Spazio tra immagine e testo

        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Text(
            text = description,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun SectionPaesaggio() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ){

        Text(
            text = "Paesaggio",
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Text(
            text = "Tra sponda piacentina e sponda lombarda, le tranquille acque del fiume si snodano tra ampie pianure, argini fioriti e rigogliosi boschi fluviali. Questo ricco e variegato ambiente naturale, punteggiato da borghi storici e attività agricole, invita a esplorare e godere della bellezza del territorio.",
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )

        SectionItemActivity(
            imageRes = R.drawable.isola_serafini,
            title = "Isola Serafini",
            description = "Nell’isola Serafini la flora presenta numerose specie di uccelli sia stanziali che migratori come rondini di mare, fraticelli, falchi, gufi, picchi e gruccioni. Per la peculiare calma e bellezza del paesaggio fluviale, oltre che la possibilità di osservare da vicino varie specie protette di uccelli acquatici, Isola Serafini è consigliata agli amanti della natura per un’escursione…",
            targetActivity = IsolaSerafiniActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.oasi_pinedo,
            title = "Oasi de Pinedo",
            description = "Nell’Oasi de Pinedo sono comuni il falco di palude e l’airone rosso. Si annoverano inoltre vari rapaci e la specie in via d’estinzione della Rana Latastei. Riscontriamo poi lucci, carpe, tinche, lasche, alborelle e molti altri animali acquatici.  Il divieto di caccia e di pesca e l’assenza di strutture artificiali immergono lo spettatore nella natura…",
            targetActivity = OasiNaturalisticaPinedoActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.elementi_climatici,
            title = "Elementi climatici",
            description = "Il clima dell’area in cui scorre il fiume Po è quello tipico della Pianura Padana, caratterizzato da estati calde ed afose, con temperature medie che possono raggiungere i 30-35°C, ed inverni freddi e umidi, con possibilità di nevicate. Le precipitazioni sono concentrate soprattutto nella stagione autunnale e primaverile, mentre i mesi estivi sono solitamente più…",
            targetActivity = ElementiClimaticiActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.paesaggio_fluviale,
            title = "Paesaggio fluviale",
            description = "Ciò che rende unico il paesaggio di questo tratto del fiume Po è senza dubbio il suo andamento sinuoso, che contribuisce a generare una grande eterogeneità di ambienti lungo le sponde. Nelle zone pianeggianti della Pianura Padana, l’argine del Po è spesso affiancato da una rigogliosa vegetazione ripariale, composta principalmente da salici, pioppi ed ontani.…",
            targetActivity = PaesaggioFluvialeActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.flora,
            title = "Flora",
            description = "Il tratto del fiume Po che attraversa la provincia di Piacenza è caratterizzato da una flora estremamente varia e ricca. Sono presenti vaste piantagioni di pioppi che costeggiano il fiume per gran parte del suo percorso. Queste piantagioni sono frutto di un’attenta gestione e coltivazione, volte a preservare l’integrità del paesaggio e la salute delle…",
            targetActivity = FloraActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.fauna,
            title = "Fauna",
            description = "La ricchezza della flora si riflette anche sulla fauna presente in questo tratto del fiume Po. Grazie all’abbondante presenza d’acqua e alla diversità di ambienti, il sito ospita una notevole varietà di specie animali. Tra gli uccelli spiccano la nitticora e l’occhione. Altre specie nidificanti legate agli ambienti acquatici sono l’airone rosso, la garzetta ed…",
            targetActivity = FaunaActivity::class.java
        )
    }
}

@Composable
fun SectionEconomia() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ){
        Text(
            text = "Economia",
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Text(
            text = "Lungo la ciclovia del Po, i ciclisti possono osservare diversi esempi di produzione energetica sostenibile e differenti impieghi della tecnologia per sfruttare le risorse naturali. Questi impianti non solo contribuiscono alla transizione energetica, ma arricchiscono anche l'esperienza del viaggio, rendendo evidente l'interazione tra natura e innovazione.",
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )

        SectionItemActivity(
            imageRes = R.drawable.levante,
            title = "Centrale termoelettrica ex Levante",
            description = "La vecchia centrale elettrica “Emilia”, realizzata dall’architetto Piero Portaluppi tra il ’25 e il ’26, in procinto di diventare un museo, si trova ancora oggi accanto all’attuale impianto in esercizio, che nasce dalla trasformazione della centrale “Levante” avvenuta tra la fine del 2002 e l’inizio del 2006. L’impianto è un moderno ciclo combinato composto da…",
            targetActivity = CentraleTermoelettricaLevanteActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.leap,
            title = "LEAP",
            description = "Il Laboratorio Energia Ambiente Piacenza (LEAP), fondato dal Politecnico di Milano nel 2005, è un centro di ricerca dedicato allo sviluppo di tecnologie energetiche efficienti e sostenibili. Situato a Piacenza, fa parte della Rete Alta Tecnologia della Regione Emilia-Romagna. LEAP si occupa di generazione di energia, recupero di materia ed energia da biomasse e rifiuti,…",
            targetActivity = LeapActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Impianto idrovoro di Borgoforte",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = ImpiantoIdrovoroBorgoforteActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Depuratore di Borgoforte",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = DepuratoreBorgoforteActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.inceneritore_termovalorizzatore,
            title = "Termovalorizzatore di Borgoforte",
            description = "Il termovalorizzatore di Borgoforte, situato nei pressi di Piacenza, rappresenta una struttura chiave nella gestione moderna dei rifiuti e nella produzione sostenibile di energia. Questo impianto innovativo utilizza il processo di termovalorizzazione per trattare i rifiuti solidi urbani in modo efficiente ed ecologico. L’approccio della termovalorizzazione coinvolge la combustione controllata dei rifiuti, trasformandoli in calore…",
            targetActivity = TermovalorizzatoreBorgoforteActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.idro_serafini,
            title = "Centrale idroelettrica dell'Isola Serafini",
            description = "L’impianto idroelettrico intitolato a Carlo Bobbio, l’architetto che curò la sua realizzazione, sorge sul territorio del Comune di Monticelli D’Ongina (Piacenza). Si tratta di una centrale ad acqua fluente – la più grande opera d’ingegneria di questo tipo in Italia – entrata in esercizio nel 1962, con lo scopo di produrre energia e anche di…",
            targetActivity = CentraleIdroelettricaIsolaSerafiniActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.finarda,
            title = "Impianto Idrovoro Finarda",
            description = "L’impianto idrovoro di Finarda, situato nei pressi di Piacenza, rappresenta una struttura fondamentale per la gestione delle risorse idriche e la protezione del territorio dalle inondazioni. Questo complesso sistema ingegneristico è progettato per controllare il livello delle acque superficiali, prevenire allagamenti e garantire un adeguato drenaggio delle aree circostanti. L’idrovoro di Finarda svolge diverse funzioni…",
            targetActivity = ImpiantoIdrovoroFinardaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.armaluga,
            title = "Impianto idrovoro Armalunga",
            description = "L’impianto idrovoro Armalunga, situato nei pressi di Piacenza, è un’infrastruttura fondamentale per la gestione delle risorse idriche e la prevenzione delle inondazioni nella regione. Questo impianto gioca un ruolo cruciale nel controllo delle acque superficiali, proteggendo il territorio da eventi meteorologici estremi, come piogge intense e fusione della neve. Attraverso un sistema di pompe ad…",
            targetActivity = ImpiantoIdrovoroArmalungaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Impianto idrovoro del Consorzio Muzio",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = ImpiantoIdrovoroConsorzioMuzioActivity::class.java
//        )
    }

}

@Composable
fun SectionStoria() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ) {

        Text(
            text = "Storia",
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Text(
            text = "Lungo la ciclovia del Po, si possono incontrare interessanti elementi storici e architettonici. I caratteristici borghi, con le loro chiese e i palazzi storici, offrono un’immersione nel passato, rendendo il percorso non solo un'esperienza naturalistica, ma anche un viaggio nella cultura nelle tradizioni locali.",
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )


        SectionItemActivity(
            imageRes = R.drawable.stazione_ferroviaria,
            title = "Stazione Piacenza",
            description = "La stazione entrò in servizio nel 1859, quando venne raggiunta dalla ferrovia proveniente da Bologna, e ne rimase capolinea fino al novembre 1861, anno in cui, a seguito della costruzione di un ponte provvisorio sul fiume Po, venne inaugurata la tratta Piacenza-Milano. All’inizio degli anni ’30 la forma planimetrica della stazione, caratterizzata dagli stilemi dell’architettura…",
            targetActivity = StazionePCActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Torrione Fodesta",
            description = "Il Torrione Fodesta, eretto dagli austriaci tra il 1850 e il 1851, ha una pianta semicircolare, caratteristica che lo rende molto simile al Torrione Borghetto, la cui planimetria è di forma semiellittica. Venne aggiunto ad un complesso preesistente, la Porta Fodesta (dal nome del Rio Fodesta, un fiume che passava lì vicino), costruita nel 1237.…",
            targetActivity = TorrioneFodestaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.ex_centrale_elettrica,
            title = "Ex Centrale Emilia",
            description = "L’impianto occupa un’area complessiva di 26.000 mq, di cui oltre 6.700 coperti. Tutti gli edifici che compongono l’impianto presentano una struttura a travi e pilastri in calcestruzzo armato, abbinato ad un tamponamento in muratura di mattoni piani a riempimento delle specchiature individuate dalle intelaiature in calcestruzzo armato. Ciò rappresenta un’importante testimonianza dell’architettura industriale di quegli…",
            targetActivity = ExCentraleEmiliaActivity::class.java
        )

//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Ponte delle Ceramiche",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = PonteDelleCeramicheActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Ponte ferroviario",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = PonteFerroviarioActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Ponte di San Rocco",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = PonteSanRoccoActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Ponte autostradale",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = PonteAutostradaActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.ponteav,
            title = "Ponte AV",
            description = "Ponte strallato in cemento armato e acciaio. Inizio lavori 2022. Inaugurazione 2006. Sviluppo complessivo di 1342 metri di cui 400 realmente strallati da 72 cavi. I lavori per la costruzione del ponte, progettato dall’ingegnere Mario Paolo Petrangeli, costarono complessivamente 43 milioni di euro e furono iniziati il 15 luglio 2002 con la posa della prima…",
            targetActivity = PonteAVActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.nino_bixio,
            title = "Società Canottieri Nino Bixio",
            description = "Sede di società sportiva (1883-84) affacciata al fiume che allena i suoi canottieri sulle acque di Po. La Società “Canottieri Nino Bixio” è parte integrante del patrimonio culturale e sportivo della città di Piacenza.Oltre all’attività agonistica, offre ai soci numerosi servizi tra cui:– una palestra attrezzata– una vasca per la pratica del canottaggio indoor– un…",
            targetActivity = NinoBixioActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.isolotto_maggi,
            title = "Isolotto Maggi",
            description = "Il Po davanti a Piacenza è ampio e tranquillo e mentre disegna ampie curve deposita sabbie che formano bellissimi spiaggioni. Dall’inizio dle 1900 fino agli anni Sessanta, grazie ad un traghetto, si poteva raggiungere l’isolotto Maggi, attrezzato per prendere il sole, fare bagni, giocare con la sabbia e mangiare gelati. L’isolotto ubicato tra le province…",
            targetActivity = IsolottoMaggiActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Impianto Idrovoro Finarda",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = ImpiantoIdrovoroFinardaActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.caorso_centrale,
            title = "Centrale Caorso",
            description = "La Centrale Nucleare di Caorso è stata un’importante infrastruttura energetica nel panorama italiano a partire dagli anni ’70. Situata sulle rive del fiume Po, nel comune di Caorso, provincia di Piacenza, questa centrale, dotata di un reattore ad acqua bollente di tipo BWR4, rappresentava una pietra miliare nella produzione di energia nucleare nel nostro Paese,…",
            targetActivity = CentraleCaorsoActivity::class.java
        )
    }


}

@Composable
fun SectionViabilità() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ){
        Text(
            text = "Viabilità",
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Text(
            text = "La ciclovia del Po in territorio piacentino e sulla sponda lombarda offre una viabilità ben strutturata, con percorsi dedicati e segnaletica chiara che garantiscono un'esperienza sicura per ciclisti e pedoni. I tratti sono perlopiù pianeggianti, adatti a ogni livello di esperienza, e si snodano lungo il fiume, collegando aree naturali e borghi storici. Questa rete ciclabile promuove un turismo sostenibile, permettendo di esplorare il territorio in modo immersivo e rispettoso.",
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Box (modifier = Modifier.padding(bottom = 4.dp, start = 16.dp, end = 16.dp)){
            Image(
                painter = painterResource(R.drawable.merli_viabilita),
                contentDescription = "mommy",
                modifier = Modifier
                    .fillMaxWidth() // Immagini ora occupano tutta la larghezza disponibile
                    .aspectRatio(3f / 2f) // Modifica il rapporto d'aspetto a 3:2 per ingrandirle
                    .clip(RoundedCornerShape(22.dp)), // Angoli molto arrotondati (32.dp)
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(8.dp)) // Spazio tra immagine e testo

        Text(
            text = "La ciclovia è composta da diverse tipologie di fondo stradale. Alcuni tratti sono condivisi con altri veicoli, il che può rappresentare un pericolo per i ciclisti meno esperti. Ci sono tratti del percorso riservati esclusivamente ai ciclisti e altri condivisi con i pedoni. Inoltre, la ciclovia include strade statali, dove il traffico di veicoli è più intenso e veloce. La superficie della strade è generalmente buona, ma la qualità può variare. Alcuni tratti sono asfaltati, altri sono ghiaiosi, mentre alcuni sono sterrati. Lungo il percorso è necessario attraversare un ponte, il che aggiunge una variazione al tragitto. Nei parcheggi tra la stazione e la ciclovia sono presenti pavimenti drenanti, che permettono il deflusso dell’acqua, evitando ristagni e allagamenti, questo migliora la sicurezza e l’accessibilità del percorso in caso di pioggia. Durante il tragitto è presente una fontanella, che permette di rifornirsi di acqua potabile, e un’area picnic con panchine e tavolini dove è possibile mangiare e utilizzare i servizi igienici. La segnaletica nella ciclovia presenta alcune criticità. Chi si trova in stazione può avere difficoltà a trovare il punto di noleggio delle bici, poiché alcuni cartelli indicano direzioni contrastanti. Inoltre, nella deviazione per il percorso della ciclovia, mancano segnali che indicano il punto esatto in cui svoltare, il che può confondere i ciclisti non del posto.",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Fontanella di Roncarolo",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = FontanellaRoncaroloActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Area di sosta di S.Nazzaro",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = AreaSostaSNazzaroActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Ponte di S.Nazzaro",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = PonteSNazzaroActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Passaggio su strada a Fossadello",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = PassaggioSuStradaFossadelloActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Partenza",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = CiclabilePonteSRoccoActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Ciclabile sul ponte di S.Rocco",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = CiclabilePonteSRoccoActivity::class.java
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Discesa dal ponte di S.Rocco",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = DiscesaDalPonteActivity::class.java
//        )
    }
}

@Composable
fun SectionTurismo() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ){

        Text(
            text = "Turismo",
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Text(
            text = "Percorrendo la ciclovia del Po, i visitatori possono esplorare borghi storici, degustare vini locali e scoprire le tradizioni culinarie della regione. Le strutture ricettive, come agriturismi e bed & breakfast, offrono accoglienza e opportunità per un turismo sostenibile, rendendo il percorso ideale per chi cerca un’esperienza autentica e immersiva nella cultura locale.",
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )

        SectionItemActivity(
            imageRes = R.drawable.finestra_po,
            title = "La finestra sul Po",
            description = "L’agriturismo “La finestra sul Po”, oltre ad offrire ottimi pasti sia a cena che a pranzo, funge come luogo di ristoro in qualsiasi giorno della settimana. Essendo situato sulle sponde del Po, offre una vista spettacolare del fiume. Questa sua posizione permette anche una completa immersione nella flora e fauna del posto.",
            targetActivity = FinestraSulPoActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.boschi_celati,
            title = "Agriturismo Boschi Celati",
            description = "Sito ufficiale",
            targetActivity = AgriturismoBoschiCelatiActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.magaton,
            title = "Magaton",
            description = "La trattoria Magaton è un luogo di ristoro situato nei pressi di Roncarolo (PC). Per raggiungere il seguente luogo è necessario percorrere un tratto di strada Argine Po. All’interno di questa struttura è possibile usufruire di servizi culinari a base di pesce pescato direttamente dal fiume. Inoltre la posizione del Magaton è favorevole anche a…",
            targetActivity = TrattoriaMagatonActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.trattoria_tonoli,
            title = "Trattoria Tonoli",
            description = "La trattoria Tonoli è un locale storico della Bassa Piacentina, a pochi minuti a piedi dal fiume Po. L’ingresso si affaccia ad un bar, piacevolmente frequentato, dal quale si accede alla sala principale a destra, che ospita un buon numero di tavoli, e a un piccolo locale sul retro, più accogliente e intimo. Le pareti,...",
            targetActivity = TrattoriaTonoliActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.trattoria_dei_viaggiatori,
            title = "Trattoria dei Viaggiatori",
            description = "La Trattoria dei Viaggiatori, situata a Caselle Landi, è un punto di riferimento per chi cerca i sapori autentici della cucina tradizionale lodigiana. Il locale, accogliente e recentemente rinnovato, propone piatti caserecci preparati con ingredienti freschi, inclusi dolci e pane fatti in casa. La gestione attenta della signora Chicca e la qualità dei piatti, come...",
            targetActivity = TrattoriaDeiViaggiatoriActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.trattoria_cattivelli,
            title = "Trattoria Cattivelli",
            description = "La trattoria Cattivelli è un accogliente ristorante situato nel cuore di San Martino. Per raggiungere questo luogo, si può percorrere la strada principale che attraversa il centro del paese. All’interno della struttura, gli ospiti possono gustare...",
            targetActivity = TrattoriaCattivelliActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.chalet_po,
            title = "Chalet sul Po",
            description = "Lo Chalet sul fiume Po oltre ad essere un’ osteria funge anche da bar. Uno dei suoi punti forti è sicuramente il paesaggio mozzafiato sulle sponde del Po che è caratterizzato da numerose colline verdi. E’ conosciuto per il servizio veloce e l’accoglienza calorosa da parte del titolare. La maggior parte dei piatti che può…",
            targetActivity = TrattoriaChaletSulPoActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.tana_roncarolo,
            title = "La tana di Roncarolo",
            description = "La tana di Roncarolo, oltre ad essere un circolo di pesca, funge anche da punto di ritrovo e banchetto per i tesserati. Il luogo è situato sulle rive del Po e oltre alla struttura in cui poter mangiare, è presente anche un attracco per barche in cui poter pescare data la posizione favorevole per la…",
            targetActivity = TanaDiRoncaroloActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.milanista,
            title = "Il Milanista",
            description = "La Dondè Trattoria, anche conosciuta come “Il Milanista”, si trova a San Nazzaro, in Emilia Romagna, Italia. Questa accogliente trattoria è rinomata per la sua eccellente pizza. Il personale amichevole lavora sodo per garantire un servizio impeccabile e contribuisce a creare un’atmosfera meravigliosa. Gli ospiti possono godersi una tranquilla atmosfera durante il loro soggiorno. Per…",
            targetActivity = TrattoriaIlMilanistaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.fontanella_roncarolo,
            title = "Fontanella di Roncarolo",
            description = "Se si ha bisogno di bere, è possibile trovare una fontanella vicino alla chiesa e al parco giochi di Roncarolo, all’interno dello stesso parco si può usufruire di un’area picnic, in caso di pioggia è protetta da un gazebo.",
            targetActivity = FontanellaRoncaroloActivity::class.java
        )
//

//
//        SectionItemActivity(
//            imageRes = R.drawable.torrione_fodesta,
//            title = "Distributore d'acqua di Mortizza",
//            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
//            targetActivity = DistributoreAcquaMortizzaActivity::class.java
//        )
    }
}

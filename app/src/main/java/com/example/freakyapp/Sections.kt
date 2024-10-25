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
import com.example.freakyapp.pagine_punti.ImpiantoIdrovoroBorgoforteActivity
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
        composable("section1") { Section1() }
        composable("section2") { Section2() }
        composable("section3") { Section3() }
        composable("section4") { Section4() }
        composable("section5") { Section5() }
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
            imageRes = R.drawable.torrione_fodesta,
            title = "Paesaggio",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            destination = "section1"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.consorzio_bonifica,
            title = "Economia",
            description = "L'impianto idrovoro rappresenta un importante elemento per l'economia circolare della regione.",
            destination = "section2"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.natura,
            title = "Storia",
            description = "Uno splendido scorcio del fiume Po, circondato da vegetazione rigogliosa.",
            destination = "section3"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.ponte_san_rocco,
            title = "Viabilità",
            description = "Il ponte di San Rocco è un'importante via di collegamento.",
            destination = "section4"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.ponte_san_rocco,
            title = "Turismo",
            description = "Il ponte di San Rocco è un'importante via di collegamento.",
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
                .clip(RoundedCornerShape(32.dp))// Angoli molto arrotondati (32.dp)
                .clickable {
                    navController.navigate(destination) // Navigazione verso la pagina specifica
                },
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(8.dp)) // Spazio tra immagine e testo

        Text(
            text = title,
            fontSize = 22.sp
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
                .clip(RoundedCornerShape(32.dp))// Angoli molto arrotondati (32.dp)
                .clickable {
                    val intent =
                        Intent(context, targetActivity) // Crea l'intento per avviare l'activity
                    context.startActivity(intent) // Avvia l'activity
                },
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(8.dp)) // Spazio tra immagine e testo

        Text(
            text = title,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(4.dp)) // Spazio tra titolo e descrizione

        Text(
            text = description,
            fontSize = 16.sp
        )
    }
}

@Composable
fun Section1() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ){
        SectionItemActivity(
            imageRes = R.drawable.isola_serafini,
            title = "Isola Serafini",
            description = "Nell’isola Serafini la flora presenta numerose specie di uccelli sia stanziali che migratori come rondini di mare, fraticelli, falchi, gufi, picchi e gruccioni.Per la peculiare calma e bellezza del paesaggio fluviale, oltre che la possibilità di osservare da vicino varie specie protette di uccelli acquatici, Isola Serafini è consigliata agli amanti della natura per un’escursione…",
            targetActivity = IsolaSerafiniActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Oasi naturalistica dell'Isola del Pinedo",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = OasiNaturalisticaPinedoActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Elementi climatici",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = ElementiClimaticiActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Paesaggio fluviale",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = PaesaggioFluvialeActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Fauna",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = FaunaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Flora",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = FloraActivity::class.java
        )
    }
}

@Composable
fun Section2() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ){
        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Centrale termoelettrica ex Levante",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = CentraleTermoelettricaLevanteActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "LEAP",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = LeapActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Impianto idrovoro di Borgoforte",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = ImpiantoIdrovoroBorgoforteActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Depuratore di Borgoforte",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = DepuratoreBorgoforteActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Termovalorizzatore di Borgoforte",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = TermovalorizzatoreBorgoforteActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Centrale idroelettrica dell'Isola Serafini",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = CentraleIdroelettricaIsolaSerafiniActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Impianto Idrovoro Finarda",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = ImpiantoIdrovoroFinardaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Impianto idrovoro Armalunga",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = ImpiantoIdrovoroArmalungaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Impianto idrovoro del Consorzio Muzio",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = ImpiantoIdrovoroConsorzioMuzioActivity::class.java
        )
    }

}

@Composable
fun Section3() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ) {
        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Stazione Piacenza",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = StazionePCActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Torrione Fodesta",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = TorrioneFodestaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Ex Centrale Emilia",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = ExCentraleEmiliaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Ponte delle Ceramiche",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = PonteDelleCeramicheActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Ponte ferroviario",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = PonteFerroviarioActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Ponte di San Rocco",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = PonteSanRoccoActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Ponte autostradale",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = PonteAutostradaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Ponte AV",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = PonteAVActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Società Canottieri Nino Bixio",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = NinoBixioActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Isolotto Maggi",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = IsolottoMaggiActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Impianto Idrovoro Finarda",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = ImpiantoIdrovoroFinardaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Centrale Caorso",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = CentraleCaorsoActivity::class.java
        )
    }


}

@Composable
fun Section4() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ){
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

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Viabilità sulla ciclovia",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = DiscesaDalPonteActivity::class.java
        )
    }
}

@Composable
fun Section5() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ){
        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "La finestra sul Po",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = FinestraSulPoActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Agriturismo Boschi Celati",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = AgriturismoBoschiCelatiActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Trattoria Magaton",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = TrattoriaMagatonActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Trattoria Tonoli",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = TrattoriaTonoliActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Trattoria dei viaggiatori",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = TrattoriaDeiViaggiatoriActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Trattoria Chalet sul Po",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = TrattoriaChaletSulPoActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "La tana di Roncarolo",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = TanaDiRoncaroloActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Trattoria il Milanista",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = TrattoriaIlMilanistaActivity::class.java
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItemActivity(
            imageRes = R.drawable.torrione_fodesta,
            title = "Distributore d'acqua di Mortizza",
            description = "Questo è il Torrione Fodesta, un esempio di architettura storica della città.",
            targetActivity = DistributoreAcquaMortizzaActivity::class.java
        )
    }
}


@Preview
@Composable
fun Sections1() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "sections") {
        composable("sections") { SectionContent(navController) }
        composable("section1") { Section1() }
        composable("section2") { Section2() }
        composable("section3") { Section3() }
        composable("section4") { Section4() }
    }
}

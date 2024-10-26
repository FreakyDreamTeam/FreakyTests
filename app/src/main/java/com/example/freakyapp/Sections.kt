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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.freakyapp.R


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
            title = "Turismo",
            description = "Il ponte di San Rocco è un'importante via di collegamento.",
            destination = "section4"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionItem(
            navController = navController,
            imageRes = R.drawable.ponte_san_rocco,
            title = "Viabilità",
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
fun Section1() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Dettagli della sezione 1: Torrione Fodesta")
    }
}

@Composable
fun Section2() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Dettagli della sezione 2: Impianto Idrovoro Finarda")
    }
}

@Composable
fun Section3() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Dettagli della sezione 3: Scorcio del Po")
    }
}

@Composable
fun Section4() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Dettagli della sezione 4: Ponte di San Rocco")
    }
}

@Composable
fun Section5() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Dettagli della sezione 5")
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

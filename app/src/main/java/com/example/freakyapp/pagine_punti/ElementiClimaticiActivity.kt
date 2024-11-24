package com.example.freakyapp.pagine_punti

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freakyapp.R

class ElementiClimaticiActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            clima(window)
        }
    }
}

@Composable
fun clima(window: Window) {
    val robotoFontFamily = FontFamily(
        Font(R.font.roboto_light)
    )

    if(isSystemInDarkTheme()){
        window.navigationBarColor = colorResource(R.color.verdenegro).toArgb()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale.
                .background(colorResource(R.color.verdenegro))
        ) {

            // Titolo con stile coerente
            Text(
                text = "Elementi climatici",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Center,
                lineHeight = 30.sp,
                letterSpacing = 0.5.sp
            )

            Box(modifier = Modifier.padding(bottom = 4.dp, start = 32.dp, end = 32.dp)){
                Image(
                    painter = painterResource(R.drawable.elementi_climatici),
                    contentDescription = "Elementi Climatici",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3f / 2f)
                        .clip(RoundedCornerShape(16.dp)),
                    //.padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                    contentScale = ContentScale.Crop
                )
            }


            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Il clima dell’area in cui scorre il fiume Po è quello tipico della Pianura Padana, caratterizzato da estati calde ed afose, con temperature medie che possono raggiungere i 30-35°C, ed inverni freddi e umidi, con possibilità di nevicate. Le precipitazioni sono concentrate soprattutto nella stagione autunnale e primaverile, mentre i mesi estivi sono solitamente più siccitosi.\n" +
                        "\n" +
                        "Questi andamenti termici e pluviometrici hanno un ruolo fondamentale nel modellare il paesaggio e nel determinare la composizione della flora e della fauna presenti. Ad esempio, l’abbondanza di acqua e l’elevata umidità favoriscono lo sviluppo di una ricca vegetazione ripariale e di zone umide, mentre le estati calde e siccitose selezionano specie vegetali più resistenti alla siccità, come molte delle piante erbacee che fioriscono lungo gli argini.\n" +
                        "\n" +
                        "Inoltre, le fluttuazioni del livello delle acque, legate alle diverse stagionalità delle precipitazioni, influenzano notevolmente la disponibilità di habitat per la fauna, determinando l’alternanza di specie meglio adattate alle condizioni di magra o di piena.\n" +
                        "\n" +
                        "Il clima della Pianura Padana, con le sue caratteristiche di termicità ed umidità, gioca un ruolo cruciale nel plasmare l’ecosistema fluviale del Po e nell’influenzare la ricca biodiversità che lo contraddistingue.",
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            )
        }
    } else {
        window.navigationBarColor = colorResource(R.color.verdechiaro).toArgb()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale.
                .background(colorResource(R.color.verdechiaro))
        ) {

            // Titolo con stile coerente
            Text(
                text = "Elementi climatici",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Center,
                lineHeight = 30.sp,
                letterSpacing = 0.5.sp
            )

            Box(modifier = Modifier.padding(bottom = 4.dp, start = 32.dp, end = 32.dp)){
                Image(
                    painter = painterResource(R.drawable.elementi_climatici),
                    contentDescription = "Elementi climatici",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3f / 2f)
                        .clip(RoundedCornerShape(16.dp)),
                    //.padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Il clima dell’area in cui scorre il fiume Po è quello tipico della Pianura Padana, caratterizzato da estati calde ed afose, con temperature medie che possono raggiungere i 30-35°C, ed inverni freddi e umidi, con possibilità di nevicate. Le precipitazioni sono concentrate soprattutto nella stagione autunnale e primaverile, mentre i mesi estivi sono solitamente più siccitosi.\n" +
                        "\n" +
                        "Questi andamenti termici e pluviometrici hanno un ruolo fondamentale nel modellare il paesaggio e nel determinare la composizione della flora e della fauna presenti. Ad esempio, l’abbondanza di acqua e l’elevata umidità favoriscono lo sviluppo di una ricca vegetazione ripariale e di zone umide, mentre le estati calde e siccitose selezionano specie vegetali più resistenti alla siccità, come molte delle piante erbacee che fioriscono lungo gli argini.\n" +
                        "\n" +
                        "Inoltre, le fluttuazioni del livello delle acque, legate alle diverse stagionalità delle precipitazioni, influenzano notevolmente la disponibilità di habitat per la fauna, determinando l’alternanza di specie meglio adattate alle condizioni di magra o di piena.\n" +
                        "\n" +
                        "Il clima della Pianura Padana, con le sue caratteristiche di termicità ed umidità, gioca un ruolo cruciale nel plasmare l’ecosistema fluviale del Po e nell’influenzare la ricca biodiversità che lo contraddistingue.",
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            )
        }
    }
}
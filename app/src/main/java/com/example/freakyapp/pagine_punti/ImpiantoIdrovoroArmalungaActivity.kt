package com.example.freakyapp.pagine_punti

import android.content.Intent
import android.net.Uri
import android.net.Uri.*
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.freakyapp.R


class ImpiantoIdrovoroArmalungaActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            armalunga(window)
        }
    }
}

@Composable
fun armalunga(window: Window){
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
                text = "Impianto Idrovoro Armalunga",
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
                    painter = painterResource(R.drawable.armaluga),
                    contentDescription = "armalunga",
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
                text = "L’impianto idrovoro Armalunga, situato nei pressi di Piacenza, è un’infrastruttura fondamentale per la gestione delle risorse idriche e la prevenzione delle inondazioni nella regione. Questo impianto gioca un ruolo cruciale nel controllo delle acque superficiali, proteggendo il territorio da eventi meteorologici estremi, come piogge intense e fusione della neve. Attraverso un sistema di pompe ad alta capacità, l’Armalunga preleva rapidamente grandi volumi d’acqua dalle aree a rischio, deviandoli verso corsi d’acqua principali o reti di drenaggio. Questo intervento è essenziale per ridurre il rischio di allagamenti e per garantire la sicurezza delle comunità locali. Oltre a prevenire inondazioni, l’impianto contribuisce anche alla regolazione delle falde acquifere, assicurando un adeguato approvvigionamento idrico per l’agricoltura, l’industria e gli usi domestici. La gestione efficiente delle acque permette di ottimizzare le risorse disponibili e sostenere l’attività agricola della zona. L’Armalunga può includere anche sistemi di trattamento delle acque reflue, migliorando la qualità delle acque rilasciate nell’ambiente e contribuendo alla salute dei corsi d’acqua locali. In sintesi, l’impianto idrovoro Armalunga è essenziale per la sicurezza e il benessere delle comunità di Piacenza, promuovendo una gestione sostenibile delle risorse idriche e preservando l’equilibrio ecologico del territorio.",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Justify,
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
                text = "Impianto Idrovoro Armalunga",
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
                    painter = painterResource(R.drawable.armaluga),
                    contentDescription = "armalunga",
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
                text = "L’impianto idrovoro Armalunga, situato nei pressi di Piacenza, è un’infrastruttura fondamentale per la gestione delle risorse idriche e la prevenzione delle inondazioni nella regione. Questo impianto gioca un ruolo cruciale nel controllo delle acque superficiali, proteggendo il territorio da eventi meteorologici estremi, come piogge intense e fusione della neve. Attraverso un sistema di pompe ad alta capacità, l’Armalunga preleva rapidamente grandi volumi d’acqua dalle aree a rischio, deviandoli verso corsi d’acqua principali o reti di drenaggio. Questo intervento è essenziale per ridurre il rischio di allagamenti e per garantire la sicurezza delle comunità locali. Oltre a prevenire inondazioni, l’impianto contribuisce anche alla regolazione delle falde acquifere, assicurando un adeguato approvvigionamento idrico per l’agricoltura, l’industria e gli usi domestici. La gestione efficiente delle acque permette di ottimizzare le risorse disponibili e sostenere l’attività agricola della zona. L’Armalunga può includere anche sistemi di trattamento delle acque reflue, migliorando la qualità delle acque rilasciate nell’ambiente e contribuendo alla salute dei corsi d’acqua locali. In sintesi, l’impianto idrovoro Armalunga è essenziale per la sicurezza e il benessere delle comunità di Piacenza, promuovendo una gestione sostenibile delle risorse idriche e preservando l’equilibrio ecologico del territorio.",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Justify,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            )
        }
    }
}
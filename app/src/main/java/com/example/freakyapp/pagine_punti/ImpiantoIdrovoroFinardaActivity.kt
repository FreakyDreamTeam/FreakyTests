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

class ImpiantoIdrovoroFinardaActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            finarda(window)
        }
    }
}

@Composable
fun finarda(window: Window){
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
                text = "Impianto Idrovoro Finarda",
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
                    painter = painterResource(R.drawable.finarda),
                    contentDescription = "Finarda",
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
                text = "L’impianto idrovoro di Finarda, situato nei pressi di Piacenza, rappresenta una struttura fondamentale per la gestione delle risorse idriche e la protezione del territorio dalle inondazioni. Questo complesso sistema ingegneristico è progettato per controllare il livello delle acque superficiali, prevenire allagamenti e garantire un adeguato drenaggio delle aree circostanti. L’idrovoro di Finarda svolge diverse funzioni cruciali. In primo luogo, attraverso pompe e canalizzazioni, è in grado di prelevare e trasferire grandi volumi di acqua dalle zone a rischio di inondazione verso corsi d’acqua principali o reti di drenaggio. Questo intervento è particolarmente importante durante periodi di piogge intense o di fusione delle nevi, quando il rischio di alluvioni è più elevato. Inoltre, l’impianto idrovoro contribuisce alla regolazione dei livelli delle falde acquifere, garantendo un adeguato approvvigionamento idrico per usi agricoli, industriali e domestici. La sua capacità di gestire e indirizzare il flusso delle acque superficiali permette di ottimizzare l’utilizzo delle risorse idriche disponibili, riducendo al contempo il rischio di inondazioni e danni alle colture. Oltre alla sua funzione principale di controllo delle acque, l’idrovoro di Finarda può anche essere dotato di sistemi di trattamento delle acque reflue, contribuendo così alla depurazione e al miglioramento della qualità delle acque che vengono rilasciate nell’ambiente. In conclusione, l’impianto idrovoro di Finarda rappresenta un importante esempio di infrastruttura idraulica progettata per proteggere le comunità dalle inondazioni, garantire una gestione sostenibile delle risorse idriche e preservare l’equilibrio ecologico dei territori circostanti. La sua presenza è fondamentale per la sicurezza e il benessere delle aree soggette a rischio idrogeologico.",
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
                text = "Impianto Idrovoro Finarda",
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
                    painter = painterResource(R.drawable.finarda),
                    contentDescription = "finarda",
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
                text = "L’impianto idrovoro di Finarda, situato nei pressi di Piacenza, rappresenta una struttura fondamentale per la gestione delle risorse idriche e la protezione del territorio dalle inondazioni. Questo complesso sistema ingegneristico è progettato per controllare il livello delle acque superficiali, prevenire allagamenti e garantire un adeguato drenaggio delle aree circostanti. L’idrovoro di Finarda svolge diverse funzioni cruciali. In primo luogo, attraverso pompe e canalizzazioni, è in grado di prelevare e trasferire grandi volumi di acqua dalle zone a rischio di inondazione verso corsi d’acqua principali o reti di drenaggio. Questo intervento è particolarmente importante durante periodi di piogge intense o di fusione delle nevi, quando il rischio di alluvioni è più elevato. Inoltre, l’impianto idrovoro contribuisce alla regolazione dei livelli delle falde acquifere, garantendo un adeguato approvvigionamento idrico per usi agricoli, industriali e domestici. La sua capacità di gestire e indirizzare il flusso delle acque superficiali permette di ottimizzare l’utilizzo delle risorse idriche disponibili, riducendo al contempo il rischio di inondazioni e danni alle colture. Oltre alla sua funzione principale di controllo delle acque, l’idrovoro di Finarda può anche essere dotato di sistemi di trattamento delle acque reflue, contribuendo così alla depurazione e al miglioramento della qualità delle acque che vengono rilasciate nell’ambiente. In conclusione, l’impianto idrovoro di Finarda rappresenta un importante esempio di infrastruttura idraulica progettata per proteggere le comunità dalle inondazioni, garantire una gestione sostenibile delle risorse idriche e preservare l’equilibrio ecologico dei territori circostanti. La sua presenza è fondamentale per la sicurezza e il benessere delle aree soggette a rischio idrogeologico.",
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
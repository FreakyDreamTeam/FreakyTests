package com.example.freakyapp.pagine_punti

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freakyapp.R

class FaunaActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            fauna(window)
        }
    }
}

@Composable
fun fauna(window: Window){
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
                text = "Fauna",
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
                    painter = painterResource(R.drawable.fauna),
                    contentDescription = "Fauna",
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
                text = "La ricchezza della flora si riflette anche sulla fauna presente in questo tratto del fiume Po. Grazie all’abbondante presenza d’acqua e alla diversità di ambienti, il sito ospita una notevole varietà di specie animali. Tra gli uccelli spiccano la nitticora e l’occhione. Altre specie nidificanti legate agli ambienti acquatici sono l’airone rosso, la garzetta ed il tarabusino. La peculiarità faunistica di quest’area risiede nell’eterogeneità degli ambienti, che attira e favorisce la migrazione di numerose famiglie di uccelli, tra cui ciconiformi, accipitriformi, caradriformi e gaviformi. Questi volatili trovano qui condizioni ideali per sosta, riproduzione ed alimentazione, essendo molto diffusi su tutto il territorio piacentino. Oltre agli uccelli, il fiume Po e le sue zone umide limitrofe ospitano anche una ricca comunità di rettili ed anfibi. Tra questi, spiccano le popolazioni di rane di Lataste, una specie endemica dell’Emilia-Romagna, le colonie di tartarughe palustri ed i tritoni crestati. È stata inoltre segnalata la presenza della natrice viperina, un serpente legato agli ambienti acquatici. La fauna del Po include anche una popolazione di pesci formata da numerose specie, tra cui lo storione, la cheppia, il barbo, la lasca e la savetta. Oltre a queste, la fauna ittica comprende altre specie di interesse conservazionistico, come il luccio, indicatore di buone condizioni ecologiche, il gobione, specie fortemente rarefatta negli ultimi decenni in Italia, e la tinca, anch’essa in declino. Questa biodiversità faunistica è il risultato di un equilibrio tra la presenza dell’elemento fluviale, la ricchezza di zone umide e la varietà di ambienti terrestri circostanti, tutti fattori che concorrono a creare le condizioni ideali per la sopravvivenza di una moltitudine di specie animali.",
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
                text = "Fauna",
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
                    painter = painterResource(R.drawable.fauna),
                    contentDescription = "Fauna",
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
                text = "La ricchezza della flora si riflette anche sulla fauna presente in questo tratto del fiume Po. Grazie all’abbondante presenza d’acqua e alla diversità di ambienti, il sito ospita una notevole varietà di specie animali. Tra gli uccelli spiccano la nitticora e l’occhione. Altre specie nidificanti legate agli ambienti acquatici sono l’airone rosso, la garzetta ed il tarabusino. La peculiarità faunistica di quest’area risiede nell’eterogeneità degli ambienti, che attira e favorisce la migrazione di numerose famiglie di uccelli, tra cui ciconiformi, accipitriformi, caradriformi e gaviformi. Questi volatili trovano qui condizioni ideali per sosta, riproduzione ed alimentazione, essendo molto diffusi su tutto il territorio piacentino. Oltre agli uccelli, il fiume Po e le sue zone umide limitrofe ospitano anche una ricca comunità di rettili ed anfibi. Tra questi, spiccano le popolazioni di rane di Lataste, una specie endemica dell’Emilia-Romagna, le colonie di tartarughe palustri ed i tritoni crestati. È stata inoltre segnalata la presenza della natrice viperina, un serpente legato agli ambienti acquatici. La fauna del Po include anche una popolazione di pesci formata da numerose specie, tra cui lo storione, la cheppia, il barbo, la lasca e la savetta. Oltre a queste, la fauna ittica comprende altre specie di interesse conservazionistico, come il luccio, indicatore di buone condizioni ecologiche, il gobione, specie fortemente rarefatta negli ultimi decenni in Italia, e la tinca, anch’essa in declino. Questa biodiversità faunistica è il risultato di un equilibrio tra la presenza dell’elemento fluviale, la ricchezza di zone umide e la varietà di ambienti terrestri circostanti, tutti fattori che concorrono a creare le condizioni ideali per la sopravvivenza di una moltitudine di specie animali.",
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
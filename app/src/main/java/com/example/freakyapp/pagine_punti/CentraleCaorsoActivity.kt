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

class CentraleCaorsoActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            caorso(window)
        }
    }
}

@Composable
fun caorso(window: Window){

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
                text = "Ex Centrale Termonucleare di Caorso",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Left,
            )

            Box(modifier = Modifier.padding(bottom = 4.dp, start = 32.dp, end = 32.dp)){
                Image(
                    painter = painterResource(R.drawable.caorso_centrale),
                    contentDescription = "Centrale Caorso",
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
                text = "La Centrale Nucleare di Caorso è stata un’importante infrastruttura energetica nel panorama italiano a partire dagli anni ’70. Situata sulle rive del fiume Po, nel comune di Caorso, provincia di Piacenza, questa centrale, dotata di un reattore ad acqua bollente di tipo BWR4, rappresentava una pietra miliare nella produzione di energia nucleare nel nostro Paese, con una capacità di 840 MW. Tuttavia, la sua attività commerciale è stata interrotta nel 1986, principalmente a causa di considerazioni politiche legate a questioni di sicurezza e all’esito di un referendum sul nucleare. Da allora, è iniziato un complesso processo di smantellamento, mirato a disattivare l’impianto e a gestire i materiali radioattivi in modo sicuro ed efficiente. Questo processo ha coinvolto varie attività, tra cui la sistemazione e il trasporto del combustibile irraggiato, il trattamento dei rifiuti radioattivi, la decontaminazione delle strutture e la rimozione di materiali pericolosi come l’amianto. Attualmente, la centrale si trova in uno stato di “arresto a freddo”, con il nocciolo del reattore scarico e i rifiuti radioattivi stoccati temporaneamente in attesa di essere trasferiti per il loro riprocessamento. Inoltre, si sta lavorando attivamente alla ricerca di un sito nazionale adeguato per il deposito finale dei rifiuti nucleari, tenendo conto di criteri di sicurezza e impatti ambientali. Questo processo, guidato da enti come la Società Gestione Impianti Nucleari (Sogin) e le autorità competenti, richiede un’attenta pianificazione e gestione per garantire la sicurezza pubblica e la protezione dell’ambiente a lungo termine.",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Justify,
                fontFamily = robotoFontFamily
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
                text = "Ex Centrale Termonucleare di Caorso",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Justify,
            )

            Box(modifier = Modifier.padding(bottom = 4.dp, start = 32.dp, end = 32.dp)){
                Image(
                    painter = painterResource(R.drawable.caorso_centrale),
                    contentDescription = "Centrale Caorso",
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
                text = "La Centrale Nucleare di Caorso è stata un’importante infrastruttura energetica nel panorama italiano a partire dagli anni ’70. Situata sulle rive del fiume Po, nel comune di Caorso, provincia di Piacenza, questa centrale, dotata di un reattore ad acqua bollente di tipo BWR4, rappresentava una pietra miliare nella produzione di energia nucleare nel nostro Paese, con una capacità di 840 MW. Tuttavia, la sua attività commerciale è stata interrotta nel 1986, principalmente a causa di considerazioni politiche legate a questioni di sicurezza e all’esito di un referendum sul nucleare. Da allora, è iniziato un complesso processo di smantellamento, mirato a disattivare l’impianto e a gestire i materiali radioattivi in modo sicuro ed efficiente. Questo processo ha coinvolto varie attività, tra cui la sistemazione e il trasporto del combustibile irraggiato, il trattamento dei rifiuti radioattivi, la decontaminazione delle strutture e la rimozione di materiali pericolosi come l’amianto. Attualmente, la centrale si trova in uno stato di “arresto a freddo”, con il nocciolo del reattore scarico e i rifiuti radioattivi stoccati temporaneamente in attesa di essere trasferiti per il loro riprocessamento. Inoltre, si sta lavorando attivamente alla ricerca di un sito nazionale adeguato per il deposito finale dei rifiuti nucleari, tenendo conto di criteri di sicurezza e impatti ambientali. Questo processo, guidato da enti come la Società Gestione Impianti Nucleari (Sogin) e le autorità competenti, richiede un’attenta pianificazione e gestione per garantire la sicurezza pubblica e la protezione dell’ambiente a lungo termine.",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}
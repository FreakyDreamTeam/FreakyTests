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

class CentraleTermoelettricaLevanteActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            centralet(window)
        }
    }
}

@Composable
fun centralet(window: Window){

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
                text = "Centrale termoelettrica ex Levante",
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
                    painter = painterResource(R.drawable.levante),
                    contentDescription = "levante",
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
                text = "La vecchia centrale elettrica “Emilia”, realizzata dall’architetto Piero Portaluppi tra il ’25 e il ’26, in procinto di diventare un museo, si trova ancora oggi accanto all’attuale impianto in esercizio, che nasce dalla trasformazione della centrale “Levante” avvenuta tra la fine del 2002 e l’inizio del 2006. L’impianto è un moderno ciclo combinato composto da 2 sezioni di produzione con turbina a gas integrata da post-combustione e da 1 sezione di produzione con turbina a vapore – che utilizza unicamente gas naturale per la combustione. L’impianto è inoltre in grado didi fornire calore, proveniente da uno “spillamento” (sottrazione di vapore della turbina a vapore), al sistema di teleriscaldamento della città di Piacenza. È attualmente in corso un intervento di sostituzione delle parti calde delle turbine a gas, con l’obiettivo di migliorare l’efficienza e le prestazioni ambientali dell’intera installazione. L’impianto così configurato entrerà in esercizio nel 2023. I lavori di costruzione della centrale termoelettrica di proprietà della Società Generale Elettrica dell’Adamello iniziarono nel 1925 e terminarono nel 1928, per consentire il regolare approvvigionamento delle regioni dell’Emilia occidentale servite direttamente dalla società o da altre imprese legate al gruppo Edison. L’impianto, progettato dal milanese Piero Portaluppi, fu inaugurato nel 1929. Nel 2003 la centrale è stata restituita al pubblico come ‘Officina della Luce’, uno spazio espositivo per l’arte contemporanea. La convenzione sottoscritta nel 2005 da Edipower e Comune di Piacenza ha consentito la realizzazione di un laboratorio di ricerca che attualmente occupa l’officina trasformatori della centrale, dichiarata di interesse culturale nel 2007.",
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
                text = "Centrale termoelettrica ex Levante",
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
                    painter = painterResource(R.drawable.levante),
                    contentDescription = "levante",
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
                text = "La vecchia centrale elettrica “Emilia”, realizzata dall’architetto Piero Portaluppi tra il ’25 e il ’26, in procinto di diventare un museo, si trova ancora oggi accanto all’attuale impianto in esercizio, che nasce dalla trasformazione della centrale “Levante” avvenuta tra la fine del 2002 e l’inizio del 2006. L’impianto è un moderno ciclo combinato composto da 2 sezioni di produzione con turbina a gas integrata da post-combustione e da 1 sezione di produzione con turbina a vapore – che utilizza unicamente gas naturale per la combustione. L’impianto è inoltre in grado didi fornire calore, proveniente da uno “spillamento” (sottrazione di vapore della turbina a vapore), al sistema di teleriscaldamento della città di Piacenza. È attualmente in corso un intervento di sostituzione delle parti calde delle turbine a gas, con l’obiettivo di migliorare l’efficienza e le prestazioni ambientali dell’intera installazione. L’impianto così configurato entrerà in esercizio nel 2023. I lavori di costruzione della centrale termoelettrica di proprietà della Società Generale Elettrica dell’Adamello iniziarono nel 1925 e terminarono nel 1928, per consentire il regolare approvvigionamento delle regioni dell’Emilia occidentale servite direttamente dalla società o da altre imprese legate al gruppo Edison. L’impianto, progettato dal milanese Piero Portaluppi, fu inaugurato nel 1929. Nel 2003 la centrale è stata restituita al pubblico come ‘Officina della Luce’, uno spazio espositivo per l’arte contemporanea. La convenzione sottoscritta nel 2005 da Edipower e Comune di Piacenza ha consentito la realizzazione di un laboratorio di ricerca che attualmente occupa l’officina trasformatori della centrale, dichiarata di interesse culturale nel 2007.",
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
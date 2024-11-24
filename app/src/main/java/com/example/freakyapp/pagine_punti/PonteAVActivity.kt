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

class PonteAVActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            av(window)
        }
    }
}

@Composable
fun av(window: Window){
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
                text = "Ponte dell'alta velocità",
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
                    painter = painterResource(R.drawable.ponteav),
                    contentDescription = "Ponte alta velocità",
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
                text = "Ponte strallato in cemento armato e acciaio. Inizio lavori 2022. Inaugurazione 2006. Sviluppo complessivo di 1342 metri di cui 400 realmente strallati da 72 cavi. I lavori per la costruzione del ponte, progettato dall’ingegnere Mario Paolo Petrangeli, costarono complessivamente 43 milioni di euro e furono iniziati il 15 luglio 2002 con la posa della prima pietra alla presenza degli allora presidente del consiglio e ministro per le infrastrutture Silvio Berlusconi e Pietro Lunardi. I primi interventi riguardarono la costruzione delle opere propedeutiche al completamento della pila numero 8, posta verso la sponda piacentina, mentre tre mesi dopo iniziarono gli analoghi interventi relativi alla pila numero 7, posta verso la sponda opposta del fiume. Il manufatto venne inaugurato il 19 giugno 2006, con la cerimonia di fine lavori. Successivamente vennero posati l’armamento e gli impianti tecnologici necessari a permettere il transito dei convogli ferroviari. La regolare circolazione sul ponte, così come sul resto della linea, ebbe inizio il 14 dicembre 2008, dopo che il giorno precedente si era tenuto il viaggio inaugurale da Milano a Bologna alla presenza delle autorità politiche.",
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
                text = "Ponte dell'alta velocità",
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
                    painter = painterResource(R.drawable.ponteav),
                    contentDescription = "Ponte alta velocità",
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
                text = "Ponte strallato in cemento armato e acciaio. Inizio lavori 2022. Inaugurazione 2006. Sviluppo complessivo di 1342 metri di cui 400 realmente strallati da 72 cavi. I lavori per la costruzione del ponte, progettato dall’ingegnere Mario Paolo Petrangeli, costarono complessivamente 43 milioni di euro e furono iniziati il 15 luglio 2002 con la posa della prima pietra alla presenza degli allora presidente del consiglio e ministro per le infrastrutture Silvio Berlusconi e Pietro Lunardi. I primi interventi riguardarono la costruzione delle opere propedeutiche al completamento della pila numero 8, posta verso la sponda piacentina, mentre tre mesi dopo iniziarono gli analoghi interventi relativi alla pila numero 7, posta verso la sponda opposta del fiume. Il manufatto venne inaugurato il 19 giugno 2006, con la cerimonia di fine lavori. Successivamente vennero posati l’armamento e gli impianti tecnologici necessari a permettere il transito dei convogli ferroviari. La regolare circolazione sul ponte, così come sul resto della linea, ebbe inizio il 14 dicembre 2008, dopo che il giorno precedente si era tenuto il viaggio inaugurale da Milano a Bologna alla presenza delle autorità politiche.",
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
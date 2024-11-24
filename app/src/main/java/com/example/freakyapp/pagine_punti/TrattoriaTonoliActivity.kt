
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

class TrattoriaTonoliActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            tonoli(window)
        }
    }
}

@Composable
fun tonoli(window: Window){


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
                text = "Trattoria Tonoli",
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
                    painter = painterResource(R.drawable.trattoria_tonoli),
                    contentDescription = "",
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
                text = "La trattoria Tonoli è un locale storico della Bassa Piacentina, a pochi minuti a piedi dal fiume Po. L’ingresso si affaccia ad un bar, piacevolmente frequentato, dal quale si accede alla sala principale a destra, che ospita un buon numero di tavoli, e a un piccolo locale sul retro, più accogliente e intimo. Le pareti, coperte di perlinato e quadri e stampe d’altri tempi, talvolta rétro, conferiscono al locale un’atmosfera calda e poco ricercata. In questo ambiente dimesso e informale, dove si incontrano spesso i soliti clienti e frequentemente la famiglia dei proprietari, si può gustare un bicchiere di vino della casa, dal sapore un po’ grezzo e genuino. Il locale offre anche qualche etichetta locale, per i palati più esigenti, e si adatta per una serata in compagnia, con la famiglia o gli amici.",
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

            Spacer(modifier = Modifier.height(8.dp))

            // Testo di descrizione con link al sito
            val context = LocalContext.current
            Text(
                text = "Link TripAdvisor",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        val url = "https://www.tripadvisor.it/Restaurant_Review-g3148606-d3873653-Reviews-Antica_Trattoria_Tonoli-Caorso_Province_of_Piacenza_Emilia_Romagna.html"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    }
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(8.dp))
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
                text = "Trattoria Tonoli",
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
                    painter = painterResource(R.drawable.trattoria_tonoli),
                    contentDescription = "",
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
                text = "La trattoria Tonoli è un locale storico della Bassa Piacentina, a pochi minuti a piedi dal fiume Po. L’ingresso si affaccia ad un bar, piacevolmente frequentato, dal quale si accede alla sala principale a destra, che ospita un buon numero di tavoli, e a un piccolo locale sul retro, più accogliente e intimo. Le pareti, coperte di perlinato e quadri e stampe d’altri tempi, talvolta rétro, conferiscono al locale un’atmosfera calda e poco ricercata. In questo ambiente dimesso e informale, dove si incontrano spesso i soliti clienti e frequentemente la famiglia dei proprietari, si può gustare un bicchiere di vino della casa, dal sapore un po’ grezzo e genuino. Il locale offre anche qualche etichetta locale, per i palati più esigenti, e si adatta per una serata in compagnia, con la famiglia o gli amici.",
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

            Spacer(modifier = Modifier.height(8.dp))

            // Testo di descrizione con link al sito
            val context = LocalContext.current
            Text(
                text = "Link TripAdvisor",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .clickable {
                        val url = "https://www.tripadvisor.it/Restaurant_Review-g3148606-d3873653-Reviews-Antica_Trattoria_Tonoli-Caorso_Province_of_Piacenza_Emilia_Romagna.html"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    }
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

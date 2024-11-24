
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

class FinestraSulPoActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            finestra(window)
        }
    }
}

@Composable
fun finestra(window: Window){

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
                text = "La finestra sul Po",
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
                    painter = painterResource(R.drawable.finestra_po),
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
                text = "L’agriturismo “La Finestra sul Po,” situato a Monticelli d’Ongina lungo il fiume Po, offre una cucina legata alla tradizione piacentina e a specialità di pesce di fiume. La struttura, ricavata da una locanda storica, propone menù stagionali e piatti come pisarei e fasò, tortelli e salumi tipici. Con ampie sale affacciate sul fiume e un’area esterna immersa nella natura, l’agriturismo offre un ambiente rilassante ideale per gustare pasti o trascorrere soggiorni tranquilli, accogliendo visitatori ogni giorno tranne il lunedì.",
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
                        val url = "https://www.tripadvisor.it/Restaurant_Review-g1966160-d5508171-Reviews-La_Finestra_sul_Po_Osteria-Monticelli_d_Ongina_Province_of_Piacenza_Emilia_Romag.html"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    }
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Link Vist Emilia",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        val url = "https://www.visitemilia.com/organizza-la-tua-visita/agriturismo-la-finestra-sul-po"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    }
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textDecoration = TextDecoration.Underline
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
                text = "La finestra sul Po",
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
                    painter = painterResource(R.drawable.finestra_po),
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
                text = "L’agriturismo “La Finestra sul Po,” situato a Monticelli d’Ongina lungo il fiume Po, offre una cucina legata alla tradizione piacentina e a specialità di pesce di fiume. La struttura, ricavata da una locanda storica, propone menù stagionali e piatti come pisarei e fasò, tortelli e salumi tipici. Con ampie sale affacciate sul fiume e un’area esterna immersa nella natura, l’agriturismo offre un ambiente rilassante ideale per gustare pasti o trascorrere soggiorni tranquilli, accogliendo visitatori ogni giorno tranne il lunedì.",
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
                        val url = "https://www.tripadvisor.it/Restaurant_Review-g1966160-d5508171-Reviews-La_Finestra_sul_Po_Osteria-Monticelli_d_Ongina_Province_of_Piacenza_Emilia_Romag.html"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    }
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Link Vist Emilia",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .clickable {
                        val url = "https://www.visitemilia.com/organizza-la-tua-visita/agriturismo-la-finestra-sul-po"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    }
                    .padding(bottom = 4.dp, start = 32.dp, end = 32.dp),
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

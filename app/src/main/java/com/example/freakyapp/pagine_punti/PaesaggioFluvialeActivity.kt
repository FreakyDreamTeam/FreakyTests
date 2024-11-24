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

class PaesaggioFluvialeActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            flu(window)
        }
    }
}

@Composable
fun flu(window : Window){
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
                text = "Paesaggio fluviale",
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
                    painter = painterResource(R.drawable.paesaggio_fluviale),
                    contentDescription = "Paesaggio fluviale",
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
                text = "Ciò che rende unico il paesaggio di questo tratto del fiume Po è senza dubbio il suo andamento sinuoso, che contribuisce a generare una grande eterogeneità di ambienti lungo le sponde. Nelle zone pianeggianti della Pianura Padana, l’argine del Po è spesso affiancato da una rigogliosa vegetazione ripariale, composta principalmente da salici, pioppi ed ontani. Questi alberi e arbusti svolgono un ruolo prezioso per la stabilità delle rive contrastando l’erosione fluviale, ed agiscono da filtro naturale per i nutrienti provenienti dalle vicine aree agricole, preservando la qualità delle acque. Allontanandosi dalla pianura e risalendo verso l’entroterra, il paesaggio fluviale si modifica sensibilmente. Qui l’argine si inserisce in un contesto più collinare, caratterizzato da dolci rilievi e terrazzi fluviali. In queste zone, la vegetazione assume una maggiore varietà, con boschi misti di latifoglie alternati a prati e coltivazioni. Questa eterogeneità ambientale si riflette anche sulla presenza di numerose zone umide come lagune, paludi e specchi d’acqua laterali, vere e proprie aree ricche di biodiversità che ospitano una consistente fauna di uccelli acquatici, anfibi, rettili ed invertebrati. In alcune aree, l’argine del Po funge anche da baluardo difensivo contro le piene, offrendo protezione alle zone circostanti. La presenza di questa infrastruttura verde, modellata ed integrata nel paesaggio, contribuisce a creare un paesaggio fluviale di grande suggestione e valore naturalistico. Diversi tratti sono stati attrezzati per accogliere percorsi ciclopedonali ed aree di sosta e ristoro, permettendo ai visitatori di godere appieno della ricchezza di questo ambiente.",
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
                text = "Paesaggio fluviale",
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
                    painter = painterResource(R.drawable.paesaggio_fluviale),
                    contentDescription = "Paesaggio fluviale",
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
                text = "Ciò che rende unico il paesaggio di questo tratto del fiume Po è senza dubbio il suo andamento sinuoso, che contribuisce a generare una grande eterogeneità di ambienti lungo le sponde. Nelle zone pianeggianti della Pianura Padana, l’argine del Po è spesso affiancato da una rigogliosa vegetazione ripariale, composta principalmente da salici, pioppi ed ontani. Questi alberi e arbusti svolgono un ruolo prezioso per la stabilità delle rive contrastando l’erosione fluviale, ed agiscono da filtro naturale per i nutrienti provenienti dalle vicine aree agricole, preservando la qualità delle acque. Allontanandosi dalla pianura e risalendo verso l’entroterra, il paesaggio fluviale si modifica sensibilmente. Qui l’argine si inserisce in un contesto più collinare, caratterizzato da dolci rilievi e terrazzi fluviali. In queste zone, la vegetazione assume una maggiore varietà, con boschi misti di latifoglie alternati a prati e coltivazioni. Questa eterogeneità ambientale si riflette anche sulla presenza di numerose zone umide come lagune, paludi e specchi d’acqua laterali, vere e proprie aree ricche di biodiversità che ospitano una consistente fauna di uccelli acquatici, anfibi, rettili ed invertebrati. In alcune aree, l’argine del Po funge anche da baluardo difensivo contro le piene, offrendo protezione alle zone circostanti. La presenza di questa infrastruttura verde, modellata ed integrata nel paesaggio, contribuisce a creare un paesaggio fluviale di grande suggestione e valore naturalistico. Diversi tratti sono stati attrezzati per accogliere percorsi ciclopedonali ed aree di sosta e ristoro, permettendo ai visitatori di godere appieno della ricchezza di questo ambiente.",
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
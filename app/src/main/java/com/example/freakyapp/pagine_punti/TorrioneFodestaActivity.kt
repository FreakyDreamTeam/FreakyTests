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

class TorrioneFodestaActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            torrione(window)
        }
    }
}

@Composable
fun torrione(window: Window){
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
                text = "Torrione Fodesta",
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
                    painter = painterResource(R.drawable.torrione_fodesta),
                    contentDescription = "Torrione fodesta",
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
                text = "Il Torrione Fodesta, eretto dagli austriaci tra il 1850 e il 1851, ha una pianta semicircolare, caratteristica che lo rende molto simile al Torrione Borghetto, la cui planimetria è di forma semiellittica. Venne aggiunto ad un complesso preesistente, la Porta Fodesta (dal nome del Rio Fodesta, un fiume che passava lì vicino), costruita nel 1237. Nel 1536 venne costruita, di fianco alla Porta, un bastione, di forma ottagonale e con la funzione di difesa della città. La forma del Torrione Fodesta, rivolto con la concavità verso la città, permetteva di difendersi dal lato del Po grazie all’artiglieria posta sul bastione, e al contempo di guardare la città per prevenire attacchi provenienti da essa. Per questo motivo erano presenti delle feritoie, ancora oggi visibili. Le finestre affacciate verso la città in origine erano di dimensioni minori. Infatti è impensabile che un edificio militare vanifichi qualsiasi tentativo di difesa utilizzando aperture delle dimensioni attuali. Le modifiche sono visibili: mentre le finestre originali avevano un’architettura di mattoni posti in verticale, quelle modificate hanno un cornicione in pietra. Il bastione e la porta vennero demoliti, e il torrione venne in seguito utilizzato come prigione (si possono ancora notare le porte con gli spioncini), infine come magazzino militare.",
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
                text = "Torrione Fodesta",
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
                    painter = painterResource(R.drawable.torrione_fodesta),
                    contentDescription = "Torrione Fodesta",
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
                text = "Il Torrione Fodesta, eretto dagli austriaci tra il 1850 e il 1851, ha una pianta semicircolare, caratteristica che lo rende molto simile al Torrione Borghetto, la cui planimetria è di forma semiellittica. Venne aggiunto ad un complesso preesistente, la Porta Fodesta (dal nome del Rio Fodesta, un fiume che passava lì vicino), costruita nel 1237. Nel 1536 venne costruita, di fianco alla Porta, un bastione, di forma ottagonale e con la funzione di difesa della città. La forma del Torrione Fodesta, rivolto con la concavità verso la città, permetteva di difendersi dal lato del Po grazie all’artiglieria posta sul bastione, e al contempo di guardare la città per prevenire attacchi provenienti da essa. Per questo motivo erano presenti delle feritoie, ancora oggi visibili. Le finestre affacciate verso la città in origine erano di dimensioni minori. Infatti è impensabile che un edificio militare vanifichi qualsiasi tentativo di difesa utilizzando aperture delle dimensioni attuali. Le modifiche sono visibili: mentre le finestre originali avevano un’architettura di mattoni posti in verticale, quelle modificate hanno un cornicione in pietra. Il bastione e la porta vennero demoliti, e il torrione venne in seguito utilizzato come prigione (si possono ancora notare le porte con gli spioncini), infine come magazzino militare.",
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
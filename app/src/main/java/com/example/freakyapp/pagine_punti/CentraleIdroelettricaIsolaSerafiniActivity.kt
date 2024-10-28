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

class CentraleIdroelettricaIsolaSerafiniActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            sera(window)
        }
    }
}

@Composable
fun sera(window: Window){
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
                text = "Centrale idroelettrica Serafini",
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
                    painter = painterResource(R.drawable.idro_serafini),
                    contentDescription = "idroserafini",
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
                text = "L’impianto idroelettrico intitolato a Carlo Bobbio, l’architetto che curò la sua realizzazione, sorge sul territorio del Comune di Monticelli D’Ongina (Piacenza). Si tratta di una centrale ad acqua fluente – la più grande opera d’ingegneria di questo tipo in Italia – entrata in esercizio nel 1962, con lo scopo di produrre energia e anche di migliorare la navigabilità tra Piacenza e Cremona. Sfrutta il dislivello creato da uno sbarramento sul Po presso Isola Serafini, la più grande isola fluviale del bacino del fiume.Tra il 2011 e il 2018 sono stati avviati i lavori per la nuova conca di Isola Serafini, l’unica presente sul Po e la più importante in Italia per il dislivello tra monte e valle dello sbarramento. La nuova conca di navigazione, oltre a ripristinare i trasporti via acqua a livello locale, è anche uno strumento importante per lo sviluppo economico e commerciale dei territori del Po. La conca, inoltre, concorre a promuovere il turismo fluviale, i numerosi itinerari artistici, culturali, enogastronomici e i percorsi ciclopedonali esistenti e in corso di progettazione, lungo tutta l’asta del fiume. La centrale svolge anche un importante ruolo di pulizia delle acque del fiume e partecipa alle iniziative lanciate dall’Autorità di Bacino del Po per proteggere l’ecosistema fluviale. Da maggio 2022 ospita il progetto “Adotta lo Storione” per favorire il ripopolamento del fiume con lo storione cobice – nome scientifico Acipenser naccarii Bonaparte – grazie anche alla partecipazione delle scuole secondarie delle province di Piacenza, Lodi e Cremona e dell’Università di Parma.",
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
                text = "Centrale idroelettrica Serafini",
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
                    painter = painterResource(R.drawable.isola_serafini),
                    contentDescription = "idorserafini",
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
                text = "L’impianto idroelettrico intitolato a Carlo Bobbio, l’architetto che curò la sua realizzazione, sorge sul territorio del Comune di Monticelli D’Ongina (Piacenza). Si tratta di una centrale ad acqua fluente – la più grande opera d’ingegneria di questo tipo in Italia – entrata in esercizio nel 1962, con lo scopo di produrre energia e anche di migliorare la navigabilità tra Piacenza e Cremona. Sfrutta il dislivello creato da uno sbarramento sul Po presso Isola Serafini, la più grande isola fluviale del bacino del fiume.Tra il 2011 e il 2018 sono stati avviati i lavori per la nuova conca di Isola Serafini, l’unica presente sul Po e la più importante in Italia per il dislivello tra monte e valle dello sbarramento. La nuova conca di navigazione, oltre a ripristinare i trasporti via acqua a livello locale, è anche uno strumento importante per lo sviluppo economico e commerciale dei territori del Po. La conca, inoltre, concorre a promuovere il turismo fluviale, i numerosi itinerari artistici, culturali, enogastronomici e i percorsi ciclopedonali esistenti e in corso di progettazione, lungo tutta l’asta del fiume. La centrale svolge anche un importante ruolo di pulizia delle acque del fiume e partecipa alle iniziative lanciate dall’Autorità di Bacino del Po per proteggere l’ecosistema fluviale. Da maggio 2022 ospita il progetto “Adotta lo Storione” per favorire il ripopolamento del fiume con lo storione cobice – nome scientifico Acipenser naccarii Bonaparte – grazie anche alla partecipazione delle scuole secondarie delle province di Piacenza, Lodi e Cremona e dell’Università di Parma.",
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
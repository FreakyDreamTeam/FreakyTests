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

class TermovalorizzatoreBorgoforteActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            term(window)
        }
    }
}

@Composable
fun term(window: Window){
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
                text = "Termovalorizzatore di Borgoforte",
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
                    painter = painterResource(R.drawable.inceneritore_termovalorizzatore),
                    contentDescription = "termov",
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
                text = "Il termovalorizzatore di Borgoforte, situato nei pressi di Piacenza, rappresenta una struttura chiave nella gestione moderna dei rifiuti e nella produzione sostenibile di energia. Questo impianto innovativo utilizza il processo di termovalorizzazione per trattare i rifiuti solidi urbani in modo efficiente ed ecologico. L’approccio della termovalorizzazione coinvolge la combustione controllata dei rifiuti, trasformandoli in calore ad alta temperatura. Questo calore viene poi utilizzato per generare vapore, il quale alimenta le turbine per la produzione di energia elettrica. Tale processo non solo contribuisce alla riduzione del volume dei rifiuti, ma fornisce anche un’importante fonte di energia pulita e rinnovabile. Il termovalorizzatore di Borgoforte si distingue per la sua tecnologia avanzata e per gli alti standard ambientali adottati. Grazie a sistemi sofisticati di filtraggio e depurazione dei gas di combustione, vengono ridotte al minimo le emissioni nocive nell’atmosfera, garantendo il rispetto delle normative ambientali più stringenti. Inoltre, l’impianto si inserisce in un contesto di economia circolare, in cui i rifiuti vengono gestiti in modo integrato e sostenibile. La produzione di energia da fonti rinnovabili contribuisce alla riduzione delle emissioni di gas serra e al miglioramento della qualità dell’aria, promuovendo un ambiente più salubre e un futuro più sostenibile per le generazioni a venire. In sintesi, il termovalorizzatore di Borgoforte rappresenta un esempio tangibile di come la tecnologia possa essere impiegata per affrontare le sfide ambientali e energetiche del nostro tempo, offrendo soluzioni innovative che coniugano efficienza, sostenibilità e rispetto dell’ambiente.",
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
                text = "Termovalorizzatore di Borgoforte",
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
                    painter = painterResource(R.drawable.inceneritore_termovalorizzatore),
                    contentDescription = "termov",
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
                text = "Il termovalorizzatore di Borgoforte, situato nei pressi di Piacenza, rappresenta una struttura chiave nella gestione moderna dei rifiuti e nella produzione sostenibile di energia. Questo impianto innovativo utilizza il processo di termovalorizzazione per trattare i rifiuti solidi urbani in modo efficiente ed ecologico. L’approccio della termovalorizzazione coinvolge la combustione controllata dei rifiuti, trasformandoli in calore ad alta temperatura. Questo calore viene poi utilizzato per generare vapore, il quale alimenta le turbine per la produzione di energia elettrica. Tale processo non solo contribuisce alla riduzione del volume dei rifiuti, ma fornisce anche un’importante fonte di energia pulita e rinnovabile. Il termovalorizzatore di Borgoforte si distingue per la sua tecnologia avanzata e per gli alti standard ambientali adottati. Grazie a sistemi sofisticati di filtraggio e depurazione dei gas di combustione, vengono ridotte al minimo le emissioni nocive nell’atmosfera, garantendo il rispetto delle normative ambientali più stringenti. Inoltre, l’impianto si inserisce in un contesto di economia circolare, in cui i rifiuti vengono gestiti in modo integrato e sostenibile. La produzione di energia da fonti rinnovabili contribuisce alla riduzione delle emissioni di gas serra e al miglioramento della qualità dell’aria, promuovendo un ambiente più salubre e un futuro più sostenibile per le generazioni a venire. In sintesi, il termovalorizzatore di Borgoforte rappresenta un esempio tangibile di come la tecnologia possa essere impiegata per affrontare le sfide ambientali e energetiche del nostro tempo, offrendo soluzioni innovative che coniugano efficienza, sostenibilità e rispetto dell’ambiente.",
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
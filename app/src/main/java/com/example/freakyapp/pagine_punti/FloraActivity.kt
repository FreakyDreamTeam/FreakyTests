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

class FloraActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            flora(window)
        }
    }
}

@Composable
fun flora(window: Window){
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
                text = "Flora",
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
                    painter = painterResource(R.drawable.flora),
                    contentDescription = "Flora",
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
                text = "Il tratto del fiume Po che attraversa la provincia di Piacenza è caratterizzato da una flora estremamente varia e ricca. Sono presenti vaste piantagioni di pioppi che costeggiano il fiume per gran parte del suo percorso. Queste piantagioni sono frutto di un’attenta gestione e coltivazione, volte a preservare l’integrità del paesaggio e la salute delle piante. Oltre ai pioppi, la vegetazione ripariale include anche altre specie arboree come salici ed ontani, che svolgono un importante ruolo di stabilizzazione delle rive e di filtro per i nutrienti provenienti dalle aree agricole limitrofe. Lungo gli argini sono presenti numerose varietà di fiori selvatici, come la pervinca dal caratteristico fiore viola intenso, il tarassaco giallo brillante, la campanula e la cicoria. Queste fioriture arricchiscono il paesaggio fluviale per tutto il periodo primaverile ed estivo. Addentrandosi nelle zone più interne, lontano dal letto del fiume, la composizione floristica cambia notevolmente, con la presenza di boschi misti di latifoglie, prati e coltivazioni, a testimonianza della varietà di ambienti presenti in quest’area.",
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
                text = "Flora",
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
                    painter = painterResource(R.drawable.flora),
                    contentDescription = "Flora",
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
                text = "Il tratto del fiume Po che attraversa la provincia di Piacenza è caratterizzato da una flora estremamente varia e ricca. Sono presenti vaste piantagioni di pioppi che costeggiano il fiume per gran parte del suo percorso. Queste piantagioni sono frutto di un’attenta gestione e coltivazione, volte a preservare l’integrità del paesaggio e la salute delle piante. Oltre ai pioppi, la vegetazione ripariale include anche altre specie arboree come salici ed ontani, che svolgono un importante ruolo di stabilizzazione delle rive e di filtro per i nutrienti provenienti dalle aree agricole limitrofe. Lungo gli argini sono presenti numerose varietà di fiori selvatici, come la pervinca dal caratteristico fiore viola intenso, il tarassaco giallo brillante, la campanula e la cicoria. Queste fioriture arricchiscono il paesaggio fluviale per tutto il periodo primaverile ed estivo. Addentrandosi nelle zone più interne, lontano dal letto del fiume, la composizione floristica cambia notevolmente, con la presenza di boschi misti di latifoglie, prati e coltivazioni, a testimonianza della varietà di ambienti presenti in quest’area.",
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
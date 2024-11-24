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

class StazionePCActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            stazione(window)
        }
    }
}

@Composable
fun stazione(window: Window){
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
                text = "Stazione ferroviaria di Piacenza",
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
                    painter = painterResource(R.drawable.stazione_ferroviaria),
                    contentDescription = "Stazione",
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
                text = "La stazione entrò in servizio nel 1859, quando venne raggiunta dalla ferrovia proveniente da Bologna, e ne rimase capolinea fino al novembre 1861, anno in cui, a seguito della costruzione di un ponte provvisorio sul fiume Po, venne inaugurata la tratta Piacenza-Milano. All’inizio degli anni ’30 la forma planimetrica della stazione, caratterizzata dagli stilemi dell’architettura militare della seconda metà del XIX secolo, fu considerata bisognosa di ammodernamento e di interventi intensivi. Il Comune demolì alcuni edifici inutili ed ingombranti, venne costruito un nuovo terminal passeggeri, dotato di biglietteria, ristorante e alloggi per i ferrovieri, oltre ad un sottopasso, una pensilina ed una nuova cabina elettrica. Nel 1932, venne aperta la ferrovia per Bettola, e dall’ottobre 1933 fu anche capolinea della linea per Cremona. Il fabbricato viaggiatori venne costruito nel 1937 su progetto di Roberto Narducci. La struttura si compone di tre corpi: il corpo centrale si presenta affiancato da due laterali in stile Novecento, caratterizzati da una pianta rettangolare e da una struttura ad archi. Il piazzale è composto da nove binari dedicati al servizio viaggiatori, mentre sul lato settentrionale dell’impianto è presente un fascio di binari ad uso dello scalo merci. Nel complesso lo scalo si estende su una superficie di circa 17000 mq.",
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
                text = "Stazione ferroviaria di Piacenza",
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
                    painter = painterResource(R.drawable.stazione_ferroviaria),
                    contentDescription = "Stazione",
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
                text = "La stazione entrò in servizio nel 1859, quando venne raggiunta dalla ferrovia proveniente da Bologna, e ne rimase capolinea fino al novembre 1861, anno in cui, a seguito della costruzione di un ponte provvisorio sul fiume Po, venne inaugurata la tratta Piacenza-Milano. All’inizio degli anni ’30 la forma planimetrica della stazione, caratterizzata dagli stilemi dell’architettura militare della seconda metà del XIX secolo, fu considerata bisognosa di ammodernamento e di interventi intensivi. Il Comune demolì alcuni edifici inutili ed ingombranti, venne costruito un nuovo terminal passeggeri, dotato di biglietteria, ristorante e alloggi per i ferrovieri, oltre ad un sottopasso, una pensilina ed una nuova cabina elettrica. Nel 1932, venne aperta la ferrovia per Bettola, e dall’ottobre 1933 fu anche capolinea della linea per Cremona. Il fabbricato viaggiatori venne costruito nel 1937 su progetto di Roberto Narducci. La struttura si compone di tre corpi: il corpo centrale si presenta affiancato da due laterali in stile Novecento, caratterizzati da una pianta rettangolare e da una struttura ad archi. Il piazzale è composto da nove binari dedicati al servizio viaggiatori, mentre sul lato settentrionale dell’impianto è presente un fascio di binari ad uso dello scalo merci. Nel complesso lo scalo si estende su una superficie di circa 17000 mq.",
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
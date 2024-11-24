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

class IsolottoMaggiActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            maggi(window)
        }
    }
}

@Composable
fun maggi(window: Window){
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
                text = "Centro sportivo Nino Bixio",
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
                    painter = painterResource(R.drawable.nino_bixio),
                    contentDescription = "Nino Bixio",
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
                text = "Il Po davanti a Piacenza è ampio e tranquillo e mentre disegna ampie curve deposita sabbie che formano bellissimi spiaggioni. Dall’inizio dle 1900 fino agli anni Sessanta, grazie ad un traghetto, si poteva raggiungere l’isolotto Maggi, attrezzato per prendere il sole, fare bagni, giocare con la sabbia e mangiare gelati. L’isolotto ubicato tra le province di Piacenza e Lodi, a est del punto di confluenza del fiume Trebbia si era formato agli inizi del 1900 a causa delle trasformazioni del corso del fiume nei decenni precedenti e ha subito rapide evoluzioni che ne hanno modificato più volte la forma e l’ubicazione.\n" +
                        "Prese il nome dall’avv. Giovanni Battista Maggi, proprietario dell’isola e del terreno golenale oggi denominato “lungo Po”, posto fra lo scalo del Genio Pontieri e il ponte per Milano. Dalla costruzione del ponte stradale del 1908 fino alla 2° guerra mondiale e poi fino ai primi anni Sessanta, nel periodo estivo, divenne un frequentatissimo luogo di balneazione.\n" +
                        "Sulla spiaggia, attrezzata con cabine e chiosco per la vendita di bibite e angurie, oltre ai bagni, si effettuavano anche le sabbiature e l’elioterapia.\n" +
                        "L’accesso in origine era garantito da una scala in legno che scendeva direttamente dal ponte mentre, nei giorni festivi, era attivo un servizio trasporti tramite le chiatte per il trasporto della sabbia riadattate con panche per i passeggeri. Il prezzo per entrambi gli accessi era di 10 centesimi di lira.\n" +
                        "L’isolotto era la “Rimini” di tutti i piacentini, allora nessuno andava in Trebbia. La domenica i traghetti facevano una spola ininterrotta dalle rive. C’erano le cabine, c’era “al Belu” con il suo chiosco delle bevande tenute fresche con i blocchi di ghiaccio fabbricati al macello che venivano grattati, quindi insaporiti con un po’ di sciroppo.\n" +
                        "Allora il pesce non mancava: stricci (lasche), alborelle, pesci gatto, cavedani, anguille erano gustati così, alla “carta”, con un po’ di pane e qualche bicchiere di vino e si concludeva in bellezza e semplicità il giorno di festa.",
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
                text = "Centro sportivo Nino Bixio",
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
                    painter = painterResource(R.drawable.nino_bixio),
                    contentDescription = "Nino Bixio",
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
                text = "Il Po davanti a Piacenza è ampio e tranquillo e mentre disegna ampie curve deposita sabbie che formano bellissimi spiaggioni. Dall’inizio dle 1900 fino agli anni Sessanta, grazie ad un traghetto, si poteva raggiungere l’isolotto Maggi, attrezzato per prendere il sole, fare bagni, giocare con la sabbia e mangiare gelati. L’isolotto ubicato tra le province di Piacenza e Lodi, a est del punto di confluenza del fiume Trebbia si era formato agli inizi del 1900 a causa delle trasformazioni del corso del fiume nei decenni precedenti e ha subito rapide evoluzioni che ne hanno modificato più volte la forma e l’ubicazione.\n" +
                        "Prese il nome dall’avv. Giovanni Battista Maggi, proprietario dell’isola e del terreno golenale oggi denominato “lungo Po”, posto fra lo scalo del Genio Pontieri e il ponte per Milano. Dalla costruzione del ponte stradale del 1908 fino alla 2° guerra mondiale e poi fino ai primi anni Sessanta, nel periodo estivo, divenne un frequentatissimo luogo di balneazione.\n" +
                        "Sulla spiaggia, attrezzata con cabine e chiosco per la vendita di bibite e angurie, oltre ai bagni, si effettuavano anche le sabbiature e l’elioterapia.\n" +
                        "L’accesso in origine era garantito da una scala in legno che scendeva direttamente dal ponte mentre, nei giorni festivi, era attivo un servizio trasporti tramite le chiatte per il trasporto della sabbia riadattate con panche per i passeggeri. Il prezzo per entrambi gli accessi era di 10 centesimi di lira.\n" +
                        "L’isolotto era la “Rimini” di tutti i piacentini, allora nessuno andava in Trebbia. La domenica i traghetti facevano una spola ininterrotta dalle rive. C’erano le cabine, c’era “al Belu” con il suo chiosco delle bevande tenute fresche con i blocchi di ghiaccio fabbricati al macello che venivano grattati, quindi insaporiti con un po’ di sciroppo.\n" +
                        "Allora il pesce non mancava: stricci (lasche), alborelle, pesci gatto, cavedani, anguille erano gustati così, alla “carta”, con un po’ di pane e qualche bicchiere di vino e si concludeva in bellezza e semplicità il giorno di festa.",
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
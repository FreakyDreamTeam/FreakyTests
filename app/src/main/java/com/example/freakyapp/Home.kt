package com.example.freakyapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle


var text_light = buildAnnotatedString {
    withStyle(style = SpanStyle(color = Color.Black)) {
        append("Pa")
    }
    withStyle(style = SpanStyle(color = Color(0xFFed4040))) {
        append("(e)(s)")
    }
    withStyle(style = SpanStyle(color = Color.Black)) {
        append("saggio di testimone")
    }
}

var text_dark = buildAnnotatedString {
    withStyle(style = SpanStyle(color = Color(0xFFed4040))) {
        append("Pa")
    }
    withStyle(style = SpanStyle(color = Color.White)) {
        append("(e)(s)")
    }
    withStyle(style = SpanStyle(color = Color(0xFFed4040))) {
        append("saggio di testimone")
    }
}


@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState()) // Abilita lo scorrimento verticale
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Centra verticalmente titolo e logo
        )
        {
            Image(
                painter = painterResource(id = R.drawable.poo), // Sostituisci con il tuo ID di risorsa logo
                contentDescription = "Logo",
                modifier = Modifier
                    .size(50.dp) // Dimensione del logo
                    .clip(RoundedCornerShape(8.dp)) // Optional: angoli arrotondati se desiderato
            )

            if(isSystemInDarkTheme()){
                Text(
                    text = text_dark,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White, // Colore verde scuro del titolo c01010
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
                )
            } else {
                Text(
                    text = text_light,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFed4040), // Colore verde scuro del titolo c01010
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp) // Margine inferiore
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Titolo principale
        Text(
            text = "Un impegno verso innovazione e sostenibilità",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFed4040), // Colore verde scuro del titolo
            modifier = Modifier.padding(bottom = 4.dp), // Margine inferiore
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        if(isSystemInDarkTheme()){
            // Sottotitolo
            Text(
                text = "Sali in sella, allaccia il casco e lasciati guidare attraverso un’esperienza unica e immersiva nella natura",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp), // Margine inferiore più grande
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "L’idea e la realizzazione del progetto",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // Colore verde scuro del titolo
                modifier = Modifier.padding(bottom = 4.dp), // Margine inferiore
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
        }else{
            // Sottotitolo
            Text(
                text = "Sali in sella, allaccia il casco e lasciati guidare attraverso un’esperienza unica e immersiva nella natura",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp), // Margine inferiore più grande
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "L’idea e la realizzazione del progetto",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black, // Colore verde scuro del titolo
                modifier = Modifier.padding(bottom = 4.dp), // Margine inferiore
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        ImageCarousel()

        Spacer(modifier = Modifier.height(16.dp))

        val text2_dark  = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color(0xFFed4040))) {
                append("Pa")
            }
            withStyle(style = SpanStyle(color = Color.White)) {
                append("(e)(s)")
            }
            withStyle(style = SpanStyle(color = Color(0xFFed4040))) {
                append("saggio di testimone è anche...")
            }
        }

        val text2_light  = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("Pa")
            }
            withStyle(style = SpanStyle(color = Color(0xFFed4040))) {
                append("(e)(s)")
            }
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("saggio di testimone è anche...")
            }
        }

        if(isSystemInDarkTheme()){
            Text(
                text = text2_dark,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // Colore verde scuro del titolo
                modifier = Modifier.padding(bottom = 4.dp), // Margine inferiore
                textAlign = TextAlign.Center
            )
        } else {
            Text(
                text = text2_light,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // Colore verde scuro del titolo
                modifier = Modifier.padding(bottom = 4.dp), // Margine inferiore
                textAlign = TextAlign.Center
            )
        }


        Spacer(modifier = Modifier.height(16.dp))


        // Primo elemento
        SectionItemNoClick(
            title = "Mappa interattiva",
            description = "un sito web con una mappa interattiva e georeferenziata dei punti di interesse come patrimonio condiviso con cittadini e turisti che si trovino a frequentare gli stessi luoghi.",
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Secondo elemento
        SectionItemNoClick(
            title = "App Android",
            description = "un’app sviluppata in Android capace di geolocalizzare l’utente lungo il percorso in bicicletta e di fornirgli informazioni sui punti di interesse vicini a lui.",
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Terzo elemento
        SectionItemNoClick(
            title = "Format",
            description = "un format per il racconto del tracciato che viene messo a disposizione delle scuole di territori prospicienti il fiume, per documentare analoghi percorsi di esplorazione educativa al paesaggio.",
        )
    }
}

@Composable
fun SectionItemNoClick(
    title: String,
    description: String
) {

    if(isSystemInDarkTheme()){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF3A5A40), shape = RoundedCornerShape(16.dp)) // Sfondo verde scuro con angoli arrotondati
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {

                if(isSystemInDarkTheme()){
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp) // Margine inferiore per separare titolo e descrizione
                    )
                    Text(
                        text = description,
                        fontSize = 16.sp,
                        color = Color.White,
                        lineHeight = 20.sp
                    )
                }else{
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp) // Margine inferiore per separare titolo e descrizione
                    )
                    Text(
                        text = description,
                        fontSize = 16.sp,
                        color = Color.Black,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }else{
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(R.color.verdescuro), shape = RoundedCornerShape(16.dp)) // Sfondo verde scuro con angoli arrotondati
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {

                if(isSystemInDarkTheme()){
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp) // Margine inferiore per separare titolo e descrizione
                    )
                    Text(
                        text = description,
                        fontSize = 16.sp,
                        color = Color.White,
                        lineHeight = 20.sp
                    )
                }else{
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp) // Margine inferiore per separare titolo e descrizione
                    )
                    Text(
                        text = description,
                        fontSize = 16.sp,
                        color = Color.Black,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}




@Composable
fun ImageCarousel() {
    val pagerState = rememberPagerState()

    // Lista di elementi da mostrare
    val carouselItems = listOf(
        CarouselItem(
            imageRes = R.drawable.carosello1,
            description = "Il progetto didattico Pa(e)(s)saggio di testimone nasce nel 2019 come laboratorio di lettura dei paesaggi fluviali, con utilizzo del linguaggio fotografico, condotto da INFOAMBIENTE (CEAS del Comune di Piacenza e parte attiva della Rete di Educazione alla Sostenibilità della Regione Emilia Romagna) sugli argini del Po, sul tracciato della futura ciclovia VENTO e nella riserva MAB UNESCO “PO GRANDE”."
        ),
        CarouselItem(
            imageRes = R.drawable.carosello2,
            description = "A partire da una prima esperienza, che realizzò la stampa in formato cartolina di 25 foto – scattate sul fiume Po dai partecipanti al corso di fotografia del paesaggio piacentino (docente: Anna Maria Belloni), cui furono abbinati testi dei ragazzi e delle ragazze delle scuole Carducci e Nicolini - dal 2021 il laboratorio permanente si è arricchito della esperienza di un percorso ad anello in bicicletta sugli argini fluviali, sperimentata con TRASPONDE, progetto coordinato da Politecnico di Milano e Autorità di Bacino Distrettuale del Fiume Po, per studiare ipotesi sostenibili di riattivazione di un servizio di traghettamento fluviale a supporto delle reti di mobilità lenta turistica."
        ),
        CarouselItem(
            imageRes = R.drawable.carosello3,
            description = "Questo sito e l’app che lo completa sono il prezioso contributo sviluppato nel 2024 da due classi dell’ISII Marconi – corso F della sezione Informatica– che dopo aver sperimentato il laboratorio nel 2021, ne sono diventate attive protagoniste fino a portarne i contenuti a Lisbona, in occasione di uno scambio Erasmus, e a mettere a disposizione le loro competenze informatiche per la realizzazione di un prodotto innovativo di valorizzazione del paesaggio fluviale e di promozione turistica del territorio, per diffondere i contenuti del progetto in una sorta di \"passaggio di testimone\"."
        ),
        CarouselItem(
            imageRes = R.drawable.carosello4,
            description = "La mappa interattiva e georeferenziata dei punti di interesse, a supporto di future uscite didattiche ma anche come modello per documentare analoghi percorsi di esplorazione educativa al paesaggio, diventa quindi patrimonio condiviso anche con cittadini e turisti che si trovino a frequentare gli stessi luoghi per il riflettere sui concetti di siti tutelati, corridoio ecologico, bacino fluviale, biodiversità, consapevolezza delle conseguenze dei nostri comportamenti, turismo responsabile ed economie sostenibili, spazi e soluzioni adeguate per favorire la ciclopedonalità, sicurezza stradale, produzione energetica, promozione territoriale oltreché per valorizzazione la bicicletta come perfetto mezzo di conoscenza dei territori marginali"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalPager(
            count = carouselItems.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .height(700.dp)
            ) {
                // Mostra immagine
                Image(
                    painter = painterResource(id = carouselItems[page].imageRes),
                    contentDescription = "Image $page",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Overlay semi-trasparente
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f)) // Aumenta o diminuisci `alpha` per regolare l'opacità
                )

                // Mostra testo sovrapposto
                Text(
                    text = carouselItems[page].description,
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
        }

        // Indicatori per le pagine
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
    }
}

// Modello dati per ogni elemento del carosello
data class CarouselItem(
    val imageRes: Int,
    val description: String
)

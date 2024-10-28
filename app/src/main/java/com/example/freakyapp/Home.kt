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

            Text(
                text = "   Pa(e)(s)saggio di testimone",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFed4040), // Colore verde scuro del titolo c01010
                modifier = Modifier.padding(bottom = 4.dp) // Margine inferiore
            )
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

        // Primo elemento
        SectionItemNoClick(
            title = "Punto #1",
            description = "La progettazione e sviluppo di un sito web con una mappa interattiva e georeferenziata dei punti di interesse che diventi patrimonio condiviso anche con cittadini e turisti che si trovino a frequentare gli stessi luoghi. La manutenzione/implementazione nel tempo sarà oggetto laboratoriale.",
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Secondo elemento
        SectionItemNoClick(
            title = "Punto #2",
            description = "La realizzazione di un’App sviluppata in Android che abbia alcune caratteristiche del sito web, in più possa geolocalizzare l’utente che fa il percorso in bicicletta e man mano gli dia informazioni sui punti di interesse in tempo reale.",
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Terzo elemento
        SectionItemNoClick(
            title = "Punto #3",
            description = "La progettazione di un format per il racconto del tracciato che possa essere messo a disposizione delle scuole di territori prospicienti il fiume, per documentare analoghi percorsi di esplorazione educativa al paesaggio.",
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




//@Composable
//fun Home(){
//    Column (
//        modifier = Modifier
//            .verticalScroll(rememberScrollState())
//    ) {
//        Box(
//            modifier = Modifier
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.po_2_scaled),
//                contentDescription = "Descrizione dell'immagine",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .align(Alignment.TopCenter)
//                    .padding(top = 20.dp)
//            )
//
//            val text = buildAnnotatedString {
//                withStyle(style = SpanStyle(color = Color.Red)) {
//                    append("PA(e)")
//                }
//                withStyle(style = SpanStyle(color = Color.Black)) {
//                    append("(s)")
//                }
//                withStyle(style = SpanStyle(color = Color.Red)) {
//                    append("SAGGIO ")
//                }
//                withStyle(style = SpanStyle(color = Color.Black)) {
//                    append("DI\n")
//                }
//                withStyle(style = SpanStyle(color = Color.Black)) {
//                    append("TESTIMONE\n")
//                }
//            }
//
//            Text(
//                text = text,
//                style = MaterialTheme.typography.headlineMedium,
//                modifier = Modifier
//                    .align(Alignment.TopCenter)
//                    .padding(top = 80.dp),
//                textAlign = TextAlign.Center
//            )
//        }
//
//        //Spacer(modifier = Modifier.height(50.dp))
//        /*
//        Image(
//            painter = painterResource(id = R.drawable.tigre),
//            contentDescription = "seconda immagine",
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(20.dp)
//        )*/
//
//        Text(
//            modifier = Modifier//🐲🫦👅fweh
//                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
//                //.padding(horizontal = 20.dp),
//            textAlign = TextAlign.Justify,
//            fontWeight = FontWeight(1000),
//            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sed metus non velit imperdiet commodo. Vestibulum volutpat porta dolor, sit amet tincidunt tortor cursus ut. Suspendisse non posuere nulla. Suspendisse felis nunc, porta at lacinia vehicula, tempor sed justo. Phasellus in est cursus tortor convallis semper cursus at est. Ut ullamcorper tortor pulvinar vulputate vehicula. Nunc ac neque in magna semper ultricies. Integer vitae tincidunt ligula, in dictum augue. Sed vitae fringilla est. Duis et eleifend tellus, a pulvinar augue. Etiam venenatis enim a sem feugiat finibus. Nunc vitae eros neque. Suspendisse tellus orci, sodales et convallis quis, pellentesque ut felis. Sed aliquet tincidunt auctor.Nam tempor orci purus. Morbi at metus ut libero laoreet lacinia nec eget elit. Praesent fringilla congue augue at tristique. Integer mauris velit, semper vestibulum pharetra eget, interdum a turpis. Nunc gravida vehicula lorem a mattis. In vel tortor efficitur nisi pharetra finibus non non nibh. Cras dignissim auctor condimentum. Sed faucibus fermentum gravida. Donec id euismod elit. Pellentesque tincidunt nisi in fermentum ultrices. Donec arcu dui, ultrices in porta a, sagittis gravida tellus."
//        )
//    }
//}
package com.example.freakyapp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import androidx.core.content.res.TypedArrayUtils.getText

@Composable
fun Home(){
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(id = R.drawable.po),
                contentDescription = "Descrizione dell'immagine",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = 20.dp)
            )

            Text(
                text = "Il guerriero dragone e la tigre",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 80.dp)
            )
        }

        //Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(id = R.drawable.tigre),
            contentDescription = "seconda immagine",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Text(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp),
                //.padding(horizontal = 20.dp),
            textAlign = TextAlign.Justify,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sed metus non velit imperdiet commodo. Vestibulum volutpat porta dolor, sit amet tincidunt tortor cursus ut. Suspendisse non posuere nulla. Suspendisse felis nunc, porta at lacinia vehicula, tempor sed justo. Phasellus in est cursus tortor convallis semper cursus at est. Ut ullamcorper tortor pulvinar vulputate vehicula. Nunc ac neque in magna semper ultricies. Integer vitae tincidunt ligula, in dictum augue. Sed vitae fringilla est. Duis et eleifend tellus, a pulvinar augue. Etiam venenatis enim a sem feugiat finibus. Nunc vitae eros neque. Suspendisse tellus orci, sodales et convallis quis, pellentesque ut felis. Sed aliquet tincidunt auctor.Nam tempor orci purus. Morbi at metus ut libero laoreet lacinia nec eget elit. Praesent fringilla congue augue at tristique. Integer mauris velit, semper vestibulum pharetra eget, interdum a turpis. Nunc gravida vehicula lorem a mattis. In vel tortor efficitur nisi pharetra finibus non non nibh. Cras dignissim auctor condimentum. Sed faucibus fermentum gravida. Donec id euismod elit. Pellentesque tincidunt nisi in fermentum ultrices. Donec arcu dui, ultrices in porta a, sagittis gravida tellus."
        )
    }
}
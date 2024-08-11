package com.example.freakyapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.freakyapp.ui.theme.FreakyAppTheme
import com.example.freakyapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreakyAppTheme {
                MainScreen()  // Chiamata alla funzione principale che gestisce l'UI
            }
        }
    }
}


@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = { MyBottomAppBar() }  // La tua barra di navigazione in basso
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FreakyAppTheme {
        MainScreen()
    }
}

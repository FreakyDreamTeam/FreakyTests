package com.example.freakyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class YourActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnotherScreen()
        }
    }
}

@Composable
fun AnotherScreen() {
    Text(text = "Benvenuto nella pagina della notifica!")
}

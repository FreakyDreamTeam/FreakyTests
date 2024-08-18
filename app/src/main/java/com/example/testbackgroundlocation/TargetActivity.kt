package com.example.testbackgroundlocation
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*

class TargetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Composables e navigazione verso altre pagine
            Home2()
        }
        Log.d("TargetActivity", "TargetActivity started")
    }
}
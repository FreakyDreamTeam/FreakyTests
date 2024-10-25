package com.example.freakyapp

import Sections
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyBottomAppBar() {
    val navController = rememberNavController() // NavController per la gestione della navigazione
    val selected = remember { mutableStateOf(Icons.Default.Home) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .padding(16.dp) // Padding per creare distanza dai bordi
                    .shadow(8.dp, RoundedCornerShape(50)) // Effetto fluttuante
                    .background(colorResource(R.color.verdescuro), RoundedCornerShape(50)), // Colore e forma arrotondata
                containerColor = Color.Transparent, // Il colore container è trasparente
                tonalElevation = 4.dp // Aggiunge un po' di elevazione
            ) {
                // Bottone Home
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navController.navigate("home") {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }

                // Bottone Mappa
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.LocationOn
                        navController.navigate("map") {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.LocationOn) Color.White else Color.DarkGray
                    )
                }

                // Bottone Sezioni
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.MoreVert
                        navController.navigate("sections") {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.MoreVert) Color.White else Color.DarkGray
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(paddingValues)) {
            composable("home") { Home() }
            composable("map") { Map(navController) }  // Schermata Mappa
            composable("sections") { Sections() }  // Schermata Sezioni
        }
    }
}

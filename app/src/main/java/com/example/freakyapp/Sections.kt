package com.example.freakyapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Sections() {
    val navController = rememberNavController()  // Creiamo il NavController per la navigazione

    NavHost(navController = navController, startDestination = "sections") {
        composable("sections") { SectionsContent(navController) }
        composable("section1") { Section1() }
        composable("section2") { Section2() }
        composable("section3") { Section3() }
    }
}
@Composable
fun SectionsContent(navController: NavController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                // Prima immagine - Diventa un bottone che porta a Section1
                Image(
                    painter = painterResource(id = R.drawable.gru),
                    contentDescription = "gru",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable {
                            navController.navigate("section1")
                        }
                )
                Text(text = "gru")

                Spacer(modifier = Modifier.height(50.dp))

                ////////////////////////////////////////////////

                // Seconda immagine - Per esempio, potrebbe navigare a un'altra sezione
                Image(
                    painter = painterResource(id = R.drawable.vipera),
                    contentDescription = "vipera",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable {
                            navController.navigate("section2")
                        }
                )
                Text(text = "vipera")

                Spacer(modifier = Modifier.height(50.dp))

                ////////////////////////////////////////////////

                // Terza immagine - Ancora un altro esempio
                Image(
                    painter = painterResource(id = R.drawable.scimmia),
                    contentDescription = "scimmia",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable {
                            navController.navigate("section3")
                        }
                )
                Text(text = "scimmia con vipera")

                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Composable
fun Section1() {
    Image(
        painter = painterResource(id = R.drawable.gru),
        contentDescription = "gru",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 20.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "1\ngru"
        )
    }
}

@Composable
fun Section2() {
    Image(
        painter = painterResource(id = R.drawable.vipera),
        contentDescription = "vipera",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 20.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "2\nvipera"
        )
    }
}

@Composable
fun Section3() {
    Image(
        painter = painterResource(id = R.drawable.scimmia),
        contentDescription = "scimmia",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 20.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "3\nscimmia"
        )
    }
}
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
        composable("section4") { Section4() }
    }
}


@Composable
fun Section1() {
    Image(
        painter = painterResource(id = R.drawable.torrione_fodesta),
        contentDescription = "torrione_fodesta",
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
            text = "1\nTorrione Fodesta"
        )
    }
}


@Composable
fun Section2() {
    Image(
        painter = painterResource(id = R.drawable.consorzio_bonifica),
        contentDescription = "consorzio_bonifica",
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
            text = "2\nImpianto Idrovoro Finarda"
        )
    }
}

@Composable
fun Section3() {
    Image(
        painter = painterResource(id = R.drawable.natura),
        contentDescription = "natura",
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
            text = "3\nScorcio del Po"
        )
    }
}

@Composable
fun Section4() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ponte_san_rocco),
            contentDescription = "ponte_san_rocco",
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
                text = "3\nPonte di San Rocco"
            )
        }


        Image(
            painter = painterResource(id = R.drawable.ponte_san_nazzaro_218116_660x368),
            contentDescription = "ponte_san_nazzaro",
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
                text = "3\nPonte di San Nazzaro"
            )
        }
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
                    painter = painterResource(id = R.drawable.torrione_fodesta),
                    contentDescription = "torrione_fodesta",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable {
                            navController.navigate("section1")
                        }
                )
                Text(text = "Storia ed architettura")

                Spacer(modifier = Modifier.height(50.dp))

                ////////////////////////////////////////////////

                // Seconda immagine - Per esempio, potrebbe navigare a un'altra sezione
                Image(
                    painter = painterResource(id = R.drawable.consorzio_bonifica),
                    contentDescription = "consorzio_bonifica",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable {
                            navController.navigate("section2")
                        }
                )
                Text(text = "Economia circolare")

                Spacer(modifier = Modifier.height(50.dp))

                ////////////////////////////////////////////////

                // Terza immagine - Ancora un altro esempio
                Image(
                    painter = painterResource(id = R.drawable.natura),
                    contentDescription = "natura",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable {
                            navController.navigate("section3")
                        }
                )
                Text(text = "Natura e biodiversità")

                Spacer(modifier = Modifier.height(50.dp))

                // quarta immagine - Ancora un altro esempio
                Image(
                    painter = painterResource(id = R.drawable.strada),
                    contentDescription = "strada",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable {
                            navController.navigate("section4")
                        }
                )
                Text(text = "Viabilità e turismo")

                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}
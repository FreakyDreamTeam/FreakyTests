package com.example.freakyapp

sealed class Screens (val screen: String){
    data object Home: Screens("home")
    data object Map: Screens("map")
    data object Sections: Screens("sections")
}
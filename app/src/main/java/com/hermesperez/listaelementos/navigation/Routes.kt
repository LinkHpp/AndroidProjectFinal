package com.hermesperez.listaelementos.navigation

sealed class Routes (val routes: String){
    object MainScreen: Routes("main_screen")
    object UserScreen: Routes("user_screen")
    object VideogameInfo: Routes("videogame_info_screen")
}
package com.hermesperez.listaelementos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hermesperez.listaelementos.ui.screens.MainScreen
import com.hermesperez.listaelementos.ui.screens.VideogameInfo
import com.hermesperez.listaelementos.ui.screens.userScreen
import com.hermesperez.listaelementos.viewmodel.NameViewModel
import com.hermesperez.listaelementos.viewmodel.VideogameViewModel


@Composable
fun Navigation(videogameViewModel: VideogameViewModel, nameViewModel: NameViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.UserScreen.routes){
        composable(Routes.MainScreen.routes){
            MainScreen(navController, videogameViewModel)
        }
        composable(Routes.VideogameInfo.routes){
            VideogameInfo(navController, videogameViewModel)
        }
        composable(Routes.UserScreen.routes){
            userScreen(navController, nameViewModel)
        }

    }
}
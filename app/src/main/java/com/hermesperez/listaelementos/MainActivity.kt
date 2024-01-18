package com.hermesperez.listaelementos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.hermesperez.listaelementos.navigation.Navigation
import com.hermesperez.listaelementos.ui.AppContent
import com.hermesperez.listaelementos.viewmodel.NameViewModel
import com.hermesperez.listaelementos.viewmodel.VideogameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val videogameViewModel by viewModels<VideogameViewModel>()
        val nameViewModel by viewModels<NameViewModel>()

        setContent {
            AppContent {
                Navigation(videogameViewModel, nameViewModel)
            }
        }
    }
}
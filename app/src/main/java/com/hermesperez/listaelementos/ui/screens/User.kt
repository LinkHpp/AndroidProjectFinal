package com.hermesperez.listaelementos.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hermesperez.listaelementos.viewmodel.NameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun userScreen(navController: NavHostController, nameViewModel: NameViewModel){
    
    val name by nameViewModel.fullname.observeAsState(initial = "")

    Column(modifier = Modifier.padding(30.dp)) {
        TextField(
            value = name,
            onValueChange = {nameViewModel.onFullnameChange(it)},
            label = {Text(text = "Nombre Completo")}
        )
        Text(text = name)

        Button(onClick = {
            nameViewModel.saveUser(name)
        }){
            Text(text = "Save name")
        }

        Button(onClick = {
            nameViewModel.loadUser()
        }) {
            Text(text = "Load User")
        }
    }

}
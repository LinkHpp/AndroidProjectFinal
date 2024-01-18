package com.hermesperez.listaelementos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hermesperez.listaelementos.model.Videogame
import com.hermesperez.listaelementos.viewmodel.VideogameViewModel

@Composable
fun VideogameInfo(navController: NavController, videogameViewModel: VideogameViewModel){
    val videogame: Videogame by videogameViewModel.selectedVideogame.observeAsState(Videogame())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.clickable {
                navController.popBackStack()
            }
        ){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver"
            )
            Text(text = "Volver")

        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.MenuBook,
                contentDescription = "videogame"
            )

            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = videogame.title,
                    fontSize = 30.sp,
                )

                favouriteStar(videogame, videogameViewModel)

                Spacer(modifier = Modifier.width(20.dp))
            }

        }

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = videogame.author,
            fontSize = 16.sp
        )
        
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(8.dp)
        ) {
            Text(
                text = "Aquí se mostrara la informacion detallada del videojuego",
                color = MaterialTheme.colorScheme.onTertiary
            )
        }

    }
}



@Composable
fun favouriteStar(videogame: Videogame,videogameViewModel: VideogameViewModel){

        if(!videogame.favourite){
            Icon(
                imageVector = Icons.Rounded.StarBorder,
                contentDescription = "videogame",
                modifier = Modifier
                    .clickable {
                        videogameViewModel.makeFavourite(videogame)
                    }
                    .size(40.dp)

            )
        }else{
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "videogame",
                tint = Color(0xFFFB8C00),
                modifier = Modifier
                    .clickable {
                        videogameViewModel.makeFavourite(videogame)
                    }
                    .size(40.dp)
            )
        }
}


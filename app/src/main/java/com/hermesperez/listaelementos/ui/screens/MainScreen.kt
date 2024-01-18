package com.hermesperez.listaelementos.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hermesperez.listaelementos.model.Videogame
import com.hermesperez.listaelementos.navigation.Routes
import com.hermesperez.listaelementos.viewmodel.VideogameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController, videogameViewModel: VideogameViewModel) {
    val videogames: List<Videogame> by videogameViewModel.videogames.observeAsState(initial = emptyList())
    val isLoadingVideogames: Boolean by videogameViewModel.isLoading.observeAsState(initial = false)


    Scaffold(
        topBar = {


            TopAppBar(
                title = {
                    Text(text = "Hermes Pérez")
                },
                colors =
                TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White,
                )

            )


        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .background(MaterialTheme.colorScheme.primary)
                .padding(vertical = 8.dp)
        ) {
            items(videogames) { videogames ->
                VideogameCard(
                    videogame = videogames,
                    navController = navController,
                    videogameViewModel = videogameViewModel
                )
            }
        }


        if (isLoadingVideogames) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Loading...",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(20.dp))
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }


    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideogameCard(
    videogame: Videogame,
    navController: NavHostController,
    videogameViewModel: VideogameViewModel
) {
    OutlinedCard(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                videogameViewModel.onBookClicked(videogame)
                navController.navigate(Routes.VideogameInfo.routes)
            }
    ) {
        ListItem(
            headlineText = { Text(text = videogame.title) },
            supportingText = { Text(text = videogame.author) },
            leadingContent = {
                if (videogame.favourite) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "videogame",
                        tint = Color(0xFFFB8C00)
                    )
                }
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    modifier = Modifier.clickable {
                        videogameViewModel.deleteVideogame(videogame)
                    },
                    contentDescription = "videogame"
                )
            }
        )
    }
}


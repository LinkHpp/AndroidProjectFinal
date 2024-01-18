package com.hermesperez.listaelementos.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hermesperez.listaelementos.ui.theme.ListaElementosTheme

@Composable
fun AppContent(content: @Composable () -> Unit){
    ListaElementosTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}
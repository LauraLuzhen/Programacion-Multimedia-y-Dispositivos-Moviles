package com.example.t3boletin1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio7() {
    // Cambiador de tamaño de texto
    var tamanioTexto by remember { mutableStateOf(20.sp) }
    val STEP = 5

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Texto ajustable",
            fontSize = tamanioTexto,
        )

        Button(
            onClick = {tamanioTexto = (tamanioTexto.value + STEP).sp}
            ) {
                Text("Aumentar")
            }

        Button(onClick = {tamanioTexto = (tamanioTexto.value - STEP).sp}
            ) {
                Text("Disminuir")
            }

    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio7Preview() {
    Ejercicio7()
}
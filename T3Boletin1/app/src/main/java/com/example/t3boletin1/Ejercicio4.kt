package com.example.t3boletin1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// EJERCICIO 1.4.
@Composable
fun Ejercicio4() {
    // Cambiador de color
    val colores = remember {
        listOf(
            Color.Red,
            Color.Blue,
            Color.Green,
            Color.Yellow
        )
    }

    var colorActual by remember { mutableStateOf(Color.Red) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(colorActual)
        )
        Button(onClick = {
            colorActual = colores.random()
        }) {
            Text("Cambiar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio4Preview() {
    Ejercicio4()
}
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

// EJERCICIO 1.3.
@Composable
fun Ejercicio3() {
    // Frases aleatorias
    val frases = remember {
        listOf(
            "Sigue adelante",
            "Nunca te rindas",
            "El código es poesía",
            "Aprende algo nuevo hoy",
            "La práctica hace al maestro"
        )
    }

    var fraseActual by remember { mutableStateOf(frases.random()) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = fraseActual,
            fontSize = 20.sp
        )

        Button(onClick = {
            fraseActual = frases.random()
        }) {
            Text("Nueva frase")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio3Preview() {
    Ejercicio3()
}
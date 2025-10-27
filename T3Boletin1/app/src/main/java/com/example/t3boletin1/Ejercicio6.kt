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

// EJERCICIO 1.6.
@Composable
fun Ejercicio6() {
    // Contador con límites y reinicio
    var contador by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = contador.toString(), fontSize = 20.sp)

        if (contador == 10) {
            Text("¡Máximo alcanzado!")
        } else if (contador == 0) {
            Text("¡Mínimo alcanzado!")
        }

        Button(onClick = {
            if (contador < 10) {
                contador++
            }
        }) {
            Text("+")
        }

        Button(onClick = {
            if (contador > 0) {
                contador--
            }
        }) {
            Text("-")
        }

        Button(onClick = {
            contador = 0
        }) {
            Text("Reiniciar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio6Preview() {
    Ejercicio6()
}
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

// EJERCICIO 1.1.
@Composable
fun Ejercicio1() {
    // Tu primera UI
    var texto by remember { mutableStateOf("¡Hola, desconocido!") }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = texto,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Button(onClick = {
            texto = "¡Has presionado el botón!"
        }) {
            Text("Pulsa aquí")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio1Preview() {
    Ejercicio1()
}
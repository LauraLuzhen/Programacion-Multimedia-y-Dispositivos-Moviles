package com.example.t3boletin1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// EJERCICIO 1.2.
@Composable
fun Ejercicio2() {
    // Tarjeta de presentación
    Card(
        modifier = Modifier.padding(20.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Laura Luzhen",
                fontSize = 25.sp
            )
            Text(
                text = "Estudiante",
                fontSize = 20.sp
            )
            Text(
                text = "ll.rodriguez@iesnervion.es",
                fontSize = 20.sp
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun Ejercicio2Preview() {
    Ejercicio2()
}
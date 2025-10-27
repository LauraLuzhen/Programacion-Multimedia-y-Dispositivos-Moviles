package com.example.t3boletin1

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

data class ImageResource(val id: Int, val description: String)

@Composable
fun Ejercicio9() {
    // Galería simple
    val imagenes = remember {
        listOf(
            ImageResource(R.drawable.ic_launcher_foreground, "Imagen 1"),
            ImageResource(R.drawable.ic_launcher_background, "Imagen 2"),
            ImageResource(R.drawable.ic_launcher_foreground, "Imagen 3")
        )
    }

    var indiceActual by remember { mutableStateOf(0) }

    val imagenActual = imagenes[indiceActual]

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imagenActual.id),
            contentDescription = imagenActual.description,
            modifier = Modifier
                .size(250.dp)
                .border(2.dp, Color.Gray)
                .padding(8.dp)
        )
        Text(
            text = imagenActual.description,
            modifier = Modifier.padding(top = 10.dp, bottom = 30.dp),
            color = Color.DarkGray
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                indiceActual = if (indiceActual == 0) imagenes.lastIndex else indiceActual - 1
            }) {
                Text("Anterior")
            }

            Button(onClick = {
                indiceActual = if (indiceActual == imagenes.lastIndex) 0 else indiceActual + 1
            }) {
                Text("Siguiente")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio9Preview() {
    Ejercicio9()
}
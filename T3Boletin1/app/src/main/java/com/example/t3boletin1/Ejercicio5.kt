package com.example.t3boletin1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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

// EJERCICIO 1.5.
@Composable
fun Ejercicio5() {
    // Tarjeta de perfil interactiva
    var mostrar by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(20.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Icono de usuario"
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Laura Luzhen", fontSize = 20.sp)

            Button(onClick = { mostrar = !mostrar }) {
                Text(if (mostrar) "Ver menos" else "Ver más")
            }

            AnimatedVisibility(visible = mostrar) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Estudiante de 2º de DAM en el instituto IES Nervión en Sevilla" +
                                " que ahora mismo está haciendo un boletín de la asignatura" +
                                " de desarrollo de aplicaciones móviles y hay muchos ejercicios" +
                                " son las 9 de la mañana hora española. :D"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio5Preview() {
    Ejercicio5()
}
package com.example.t32.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.t32.domain.entities.Contacto
import com.example.t32.domain.repositories.Repositorio

@Composable
fun ContactRow(contacto: Contacto) {
    var showFullDetails by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.size(100.dp).clickable { showFullDetails = !showFullDetails },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (showFullDetails) {
                    Image(
                        painter = painterResource(id = contacto.genero.imageResId),
                        contentDescription = "Foto contacto",
                        modifier = Modifier.size(100.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = contacto.genero.imageResId),
                        contentDescription = "Foto contacto",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(
                        text = getInitials(contacto.name),
                        fontSize = 32.sp
                    )
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Column(
            ) {
                if (showFullDetails) {
                    Text(
                        text = "ID: ${contacto.id}"
                    )
                    Text(
                        text = "Nombre: ${contacto.name}"
                    )
                    Text(
                        text = "Teléfono: ${contacto.phoneNumber}"
                    )
                    Text(
                        text = "Género: ${contacto.genero.name}"
                    )
                } else {
                    Text(
                        text = getInitials(contacto.name),
                        fontSize = 24.sp
                    )
                }
            }
        }
    }


}

fun getInitials(name: String): String {
    val parts = name.split(" ")
    return when {
        parts.isEmpty() -> ""
        parts.size == 1 -> parts[0].first().uppercase()
        else -> "${parts.first().first()}${parts.last().first()}".uppercase()
    }
}

@Composable
fun ContactsScreen(navController: NavController, modifier: Modifier = Modifier) {
    val lista = Repositorio.getAllContacts()

    Scaffold(
        modifier = modifier.padding(all = 24.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("formulario")
            }) {
                Text(
                    text = "+",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(lista) { itemContacto ->
                ContactRow(contacto = itemContacto)
            }
        }
    }
}
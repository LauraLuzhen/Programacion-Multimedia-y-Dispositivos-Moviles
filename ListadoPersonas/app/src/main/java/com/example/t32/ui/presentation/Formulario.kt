package com.example.t32.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.t32.domain.entities.ContactoEntity
import com.example.t32.domain.entities.Genero

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioContacto(
    navController: NavController,
    // El ViewModel se recibe como parámetro
    viewModel: ContactoViewModel
) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    // Inicialización del estado del género usando el enum
    var selectedGenero by remember { mutableStateOf(Genero.OTRO) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nuevo Contacto") },
                navigationIcon = {
                    TextButton(onClick = { navController.popBackStack() }) {
                        Text("< VOLVER")
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = { Text("Teléfono") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(24.dp))

                Text("Género:", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))

                // --- Selección de Género (Usando el enum Genero) ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Iterar sobre todos los valores del enum Genero
                    Genero.entries.forEach { genero ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable { selectedGenero = genero }
                        ) {
                            RadioButton(
                                selected = (genero == selectedGenero),
                                onClick = { selectedGenero = genero }
                            )
                            // Mostrar el nombre del enum (MASCULINO, FEMENINO, OTRO)
                            Text(genero.name, modifier = Modifier.padding(start = 4.dp))

                            // Nota: Para usar el 'imageResId' tendrías que añadir un Image
                            // val image = painterResource(id = genero.imageResId)
                            // Image(painter = image, contentDescription = null, ...)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        // 1. Construir la entidad de Room
                        val newContactoEntity = ContactoEntity(
                            name = name,
                            phoneNumber = phoneNumber,
                            // Convertimos el valor seleccionado del enum a String (su nombre)
                            genero = selectedGenero.name
                        )

                        // 2. Llamar al ViewModel para guardar
                        viewModel.addContacto(newContactoEntity)

                        // 3. Navegar
                        navController.navigate("lista") {
                            popUpTo("lista") { inclusive = true }
                        }
                    },
                    enabled = name.isNotBlank() && phoneNumber.isNotBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Guardar Contacto")
                }
            }
        }
    )
}
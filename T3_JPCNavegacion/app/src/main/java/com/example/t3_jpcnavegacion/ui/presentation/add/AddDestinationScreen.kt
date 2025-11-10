package com.example.t3_jpcnavegacion.ui.presentation.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDestinationScreen(
    viewModel: AddDestinationViewModel = viewModel(),
    onBack: () -> Unit // El callback de navegación
) {
    val state by viewModel.state.collectAsState()

    // Obtener una referencia estable del callback de navegación
    val onBackStable by rememberUpdatedState(onBack)

    // ⬅️ ¡AÑADIR ESTE BLOQUE!
    // -----------------------------------------------------------
    LaunchedEffect(state.isAdded) {
        // Solo navega si la adición fue marcada como exitosa
        if (state.isAdded) {
            onBackStable()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Agregar Nuevo Destino") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Campo Nombre
            OutlinedTextField(
                value = state.name,
                onValueChange = viewModel::onNameChange,
                label = { Text("Nombre del Destino") },
                isError = state.errorMessage != null && state.name.isBlank(),
                modifier = Modifier.fillMaxWidth()
            )

            // Campo País
            OutlinedTextField(
                value = state.country,
                onValueChange = viewModel::onCountryChange,
                label = { Text("País") },
                isError = state.errorMessage != null && state.country.isBlank(),
                modifier = Modifier.fillMaxWidth()
            )

            // Campo Descripción
            OutlinedTextField(
                value = state.description,
                onValueChange = viewModel::onDescriptionChange,
                label = { Text("Descripción") },
                isError = state.errorMessage != null && state.description.isBlank(),
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            // Mensaje de error (Validación)
            state.errorMessage?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(Modifier.height(8.dp))

            // Botón Agregar
            Button(
                onClick = viewModel::addDestination,
                enabled = !state.isLoading,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Agregar")
                }
            }

            Spacer(Modifier.height(16.dp))
            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    }
}
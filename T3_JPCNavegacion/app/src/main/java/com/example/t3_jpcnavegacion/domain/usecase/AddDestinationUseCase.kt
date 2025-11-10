package com.example.t3_jpcnavegacion.domain.usecase

import com.example.t3_jpcnavegacion.domain.model.Destination
import com.example.t3_jpcnavegacion.domain.repository.DestinationRepository

class AddDestinationUseCase(
    private val repository: DestinationRepository
) {
    // El ID se gestionará en la capa de datos/repositorio, por lo que lo inicializamos a 0
    suspend operator fun invoke(name: String, country: String, description: String) {
        if (name.isBlank() || country.isBlank() || description.isBlank()) {
            throw IllegalArgumentException("Todos los campos deben estar llenos.")
        }

        val newDestination = Destination(
            id = 0, // El repositorio le asignará un ID real
            name = name.trim(),
            country = country.trim(),
            description = description.trim(),
            imageUrl = "url_temporal" // Valor por defecto
        )
        repository.addDestination(newDestination)
    }
}
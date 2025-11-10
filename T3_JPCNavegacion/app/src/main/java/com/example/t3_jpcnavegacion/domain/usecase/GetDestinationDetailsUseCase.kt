package com.example.t3_jpcnavegacion.domain.usecase

import com.example.t3_jpcnavegacion.data.repository.DestinationRepositoryImpl
import com.example.t3_jpcnavegacion.domain.model.Destination
import com.example.t3_jpcnavegacion.domain.repository.DestinationRepository

class GetDestinationDetailsUseCase(private val repository: DestinationRepository) {
    // Debe ser una función suspendida para hacer llamadas de red/DB
    // que son asíncronas y bloqueantes.
    suspend operator fun invoke(destinationId: Int): Destination? {
        return repository.getDestinationById(destinationId)
    }
}
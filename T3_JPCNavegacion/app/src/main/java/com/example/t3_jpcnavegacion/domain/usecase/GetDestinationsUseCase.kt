package com.example.t3_jpcnavegacion.domain.usecase

import com.example.t3_jpcnavegacion.domain.model.Destination
import com.example.t3_jpcnavegacion.domain.repository.DestinationRepository

class GetDestinationsUseCase(
    private val repository: DestinationRepository
) {
    suspend operator fun invoke(): List<Destination> {
        return repository.getDestinations()
    }
}
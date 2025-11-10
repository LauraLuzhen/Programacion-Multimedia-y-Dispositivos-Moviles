package com.example.t3_jpcnavegacion.domain.repository

import com.example.t3_jpcnavegacion.domain.model.Destination

interface DestinationRepository {
    suspend fun getDestinations(): List<Destination>
    suspend fun getDestinationById(id: Int): Destination?
    suspend fun addDestination(destination: Destination)
}
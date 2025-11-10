package com.example.t3_jpcnavegacion.data.source

import com.example.t3_jpcnavegacion.data.model.DestinationDto

interface DestinationDataSource {
    suspend fun getAllDestinations(): List<DestinationDto>
    suspend fun getDestinationById(id: Int): DestinationDto?
    suspend fun saveDestination(destination: DestinationDto)
}
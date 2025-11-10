package com.example.t3_jpcnavegacion.data.repository

import com.example.t3_jpcnavegacion.data.model.toDomain
import com.example.t3_jpcnavegacion.data.model.toDto
import com.example.t3_jpcnavegacion.data.source.DestinationDataSource
import com.example.t3_jpcnavegacion.data.source.MockDestinationDataSource
import com.example.t3_jpcnavegacion.domain.model.Destination
import com.example.t3_jpcnavegacion.domain.repository.DestinationRepository

class DestinationRepositoryImpl(
    private val dataSource: DestinationDataSource = MockDestinationDataSource // Usamos el mock por defecto
) : DestinationRepository {

    override suspend fun getDestinations(): List<Destination> {
        // Llama a la fuente de datos (que devuelve DTOs) y mapea a modelos de Dominio
        return dataSource.getAllDestinations().map { it.toDomain() }
    }

    override suspend fun getDestinationById(id: Int): Destination? {
        // Llama a la fuente de datos y mapea a modelo de Dominio
        return dataSource.getDestinationById(id)?.toDomain()
    }

    override suspend fun addDestination(destination: Destination) {
        // Mapea el modelo de Dominio a DTO y lo guarda usando la fuente de datos
        dataSource.saveDestination(destination.toDto())
    }
}
package com.example.t3_jpcnavegacion.data.source

import com.example.t3_jpcnavegacion.data.model.DestinationDto
import com.example.t3_jpcnavegacion.domain.model.Destination

object MockDestinationDataSource : DestinationDataSource {

    // Lista mutable interna usando DTOs
    private val destinations = mutableListOf(
        DestinationDto(
            1,
            "Tokio",
            "Japón",
            "Metrópolis vibrante con historia y modernidad.",
            "url_tokio"
        ),
        DestinationDto(2, "París", "Francia", "La Ciudad de la Luz, famosa por su arte y gastronomía.", "url_paris"),
        DestinationDto(3, "Río de Janeiro", "Brasil", "Playas espectaculares y carnavales llenos de vida.", "url_rio")
    )

    override suspend fun getAllDestinations(): List<DestinationDto> {
        return destinations.toList()
    }

    override suspend fun getDestinationById(id: Int): DestinationDto? {
        return destinations.find { it.id == id }
    }

    override suspend fun saveDestination(destination: DestinationDto) {
        val newId = (destinations.maxOfOrNull { it.id } ?: 0) + 1
        destinations.add(destination.copy(id = newId))
    }
}
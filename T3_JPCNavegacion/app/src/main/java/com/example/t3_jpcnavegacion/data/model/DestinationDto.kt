package com.example.t3_jpcnavegacion.data.model

data class DestinationDto(
    val id: Int,
    val name: String,
    val country: String,
    val description: String,
    // Podríamos usar un nombre de campo distinto para simular un mapeo real
    val photoUrl: String
)

// Función de extensión para mapear del DTO al modelo de Dominio
fun DestinationDto.toDomain() = com.example.t3_jpcnavegacion.domain.model.Destination(
    id = this.id,
    name = this.name,
    country = this.country,
    description = this.description,
    imageUrl = this.photoUrl
)

// Función de extensión para mapear del modelo de Dominio al DTO
fun com.example.t3_jpcnavegacion.domain.model.Destination.toDto() = DestinationDto(
    id = this.id,
    name = this.name,
    country = this.country,
    description = this.description,
    photoUrl = this.imageUrl
)

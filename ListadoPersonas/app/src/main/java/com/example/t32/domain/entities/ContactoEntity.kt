package com.example.t32.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_entity")
data class ContactoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var phoneNumber: String = "",
    var genero: Genero = Genero.OTRO
)

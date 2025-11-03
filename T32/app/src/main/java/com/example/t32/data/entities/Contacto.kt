package com.example.t32.data.entities

class Contacto (
    val id:Int,
    val name: String,
    val phoneNumber: String,
    val genero: Genero = Genero.OTRO
    )
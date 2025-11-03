package com.example.t32.domain.repositories

import com.example.t32.data.entities.Contacto
import com.example.t32.data.entities.Genero

object Repositorio {
    val  lista = mutableListOf<Contacto>(
        Contacto(1, "Juan García", "611123456", Genero.MASCULINO),
        Contacto(2, "María López", "678456123", Genero.FEMENINO),
        Contacto(3, "Raúl Cimas", "644789456", Genero.MASCULINO),
        Contacto(4, "Ana Morantes", "693882147", Genero.FEMENINO),
        Contacto(id=5, name = "Laura Rodríguez", phoneNumber = "12345678", Genero.FEMENINO),
        Contacto(id=6, name = "Pedro Gómez", phoneNumber = "87654321", Genero.MASCULINO),
        Contacto(id=7, name = "Sofía García", phoneNumber = "55555555", Genero.FEMENINO),
        Contacto(id=8, name = "Carlos Martínez", phoneNumber = "99999999", Genero.MASCULINO),
        Contacto(id=9, name = "Ana López", phoneNumber = "11111111", Genero.FEMENINO),
        Contacto(id=10, name = "Luis Fernández", phoneNumber = "22222222", Genero.MASCULINO),
    )

    fun getAllContacts():List<Contacto> {
        return lista
    }

    fun addContact(contacto: Contacto) {
        lista.add(contacto)

    }
}

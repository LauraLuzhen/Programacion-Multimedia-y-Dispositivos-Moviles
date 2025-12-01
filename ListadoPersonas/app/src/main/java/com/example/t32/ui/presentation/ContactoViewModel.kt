package com.example.t32.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t32.data.ContactoRepository
import com.example.t32.domain.entities.ContactoEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Necesitarás una factoría o inyección de dependencias para instanciar esto
class ContactoViewModel(private val repository: ContactoRepository) : ViewModel() {

    // (Asumiendo que tienes un StateFlow para la lista de contactos)
    private val _contactos = MutableStateFlow<List<ContactoEntity>>(emptyList())
    val contactos: StateFlow<List<ContactoEntity>> = _contactos

    // ... (Inicialización y recolección de contactos omitida por brevedad)

    /**
     * Guarda un nuevo contacto en la base de datos a través del repositorio.
     */
    fun addContacto(contacto: ContactoEntity) {
        viewModelScope.launch {
            repository.addTask(contacto)
        }
    }
}
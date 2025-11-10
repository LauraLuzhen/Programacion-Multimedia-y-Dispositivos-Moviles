package com.example.t3_jpcnavegacion.ui.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t3_jpcnavegacion.data.repository.DestinationRepositoryImpl
import com.example.t3_jpcnavegacion.domain.usecase.AddDestinationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AddDestinationState(
    val name: String = "",
    val country: String = "",
    val description: String = "",
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
    val isAdded: Boolean = false
)

class AddDestinationViewModel : ViewModel() {
    private val addDestinationUseCase = AddDestinationUseCase(DestinationRepositoryImpl())

    private val _state = MutableStateFlow(AddDestinationState())
    val state: StateFlow<AddDestinationState> = _state

    fun onNameChange(newName: String) {
        _state.update { it.copy(name = newName, errorMessage = null) }
    }

    fun onCountryChange(newCountry: String) {
        _state.update { it.copy(country = newCountry, errorMessage = null) }
    }

    fun onDescriptionChange(newDescription: String) {
        _state.update { it.copy(description = newDescription, errorMessage = null) }
    }

    fun addDestination() {
        _state.update { it.copy(isLoading = true, errorMessage = null) }
        viewModelScope.launch {
            try {
                addDestinationUseCase(
                    name = _state.value.name,
                    country = _state.value.country,
                    description = _state.value.description
                )
                // Éxito
                _state.update { it.copy(isLoading = false, isAdded = true) }
            } catch (e: IllegalArgumentException) {
                // Fallo de validación del Dominio
                _state.update { it.copy(isLoading = false, errorMessage = e.message) }
            } catch (e: Exception) {
                // Otros errores
                _state.update { it.copy(isLoading = false, errorMessage = "Error al guardar el destino.") }
            }
        }
    }
}
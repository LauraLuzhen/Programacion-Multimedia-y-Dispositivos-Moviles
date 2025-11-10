package com.example.t3_jpcnavegacion.ui.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t3_jpcnavegacion.data.repository.DestinationRepositoryImpl
import com.example.t3_jpcnavegacion.domain.model.Destination
import com.example.t3_jpcnavegacion.domain.usecase.GetDestinationDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val destinationId: Int // El ID se pasa al constructor, simulando savedStateHandle
) : ViewModel() {
    private val getDestinationDetailsUseCase = GetDestinationDetailsUseCase(DestinationRepositoryImpl())

    private val _destination = MutableStateFlow<Destination?>(null)
    val destination: StateFlow<Destination?> = _destination

    init {
        loadDestinationDetails()
    }

    private fun loadDestinationDetails() {
        viewModelScope.launch {
            _destination.value = getDestinationDetailsUseCase(destinationId)
        }
    }
}
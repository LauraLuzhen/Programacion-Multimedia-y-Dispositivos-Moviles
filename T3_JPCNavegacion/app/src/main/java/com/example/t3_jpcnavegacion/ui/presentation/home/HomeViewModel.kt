package com.example.t3_jpcnavegacion.ui.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t3_jpcnavegacion.domain.model.Destination
import com.example.t3_jpcnavegacion.domain.usecase.GetDestinationsUseCase
import com.example.t3_jpcnavegacion.data.repository.DestinationRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val getDestinationsUseCase = GetDestinationsUseCase(DestinationRepositoryImpl())

    private val _destinations = MutableStateFlow<List<Destination>>(emptyList())
    val destinations: StateFlow<List<Destination>> = _destinations

    init {
        loadDestinations()
    }

    fun loadDestinations() {
        viewModelScope.launch {
            _destinations.value = getDestinationsUseCase()
        }
    }
}
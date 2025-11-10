package com.example.t3_jpcnavegacion.ui.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailViewModelFactory(
    private val destinationId: Int
) : ViewModelProvider.Factory {
    // Necesitas importar androidx.lifecycle.ViewModelProvider.Factory
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(destinationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
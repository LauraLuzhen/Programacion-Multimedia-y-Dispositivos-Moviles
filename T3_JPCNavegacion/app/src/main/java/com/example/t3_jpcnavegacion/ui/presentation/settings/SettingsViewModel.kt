package com.example.t3_jpcnavegacion.ui.presentation.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class SettingsState(
    val isDarkModeEnabled: Boolean = false,
    val isNotificationEnabled: Boolean = true
)

class SettingsViewModel : ViewModel() {
    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state

    /**
     * Alterna el estado del Modo Oscuro.
     * En una app real, esta acción actualizaría el tema de la aplicación.
     */
    fun toggleDarkMode(isEnabled: Boolean) {
        // Aquí llamarías a un UseCase para guardar la preferencia en DataStore/SharedPreferences
        _state.update { it.copy(isDarkModeEnabled = isEnabled) }
    }

    /**
     * Alterna el estado de las Notificaciones.
     * En una app real, aquí se ajustaría la configuración del sistema de notificaciones.
     */
    fun toggleNotifications(isEnabled: Boolean) {
        // Aquí llamarías a un UseCase para guardar la preferencia
        _state.update { it.copy(isNotificationEnabled = isEnabled) }
    }
}
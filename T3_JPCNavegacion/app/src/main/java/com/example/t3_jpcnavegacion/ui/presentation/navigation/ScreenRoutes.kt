package com.example.t3_jpcnavegacion.ui.presentation.navigation

object ScreenRoutes {
    const val HOME = "home"
    const val DETAIL = "detail/{destinationId}"
    const val ADD = "add"
    const val SETTINGS = "settings"

    fun detailRoute(destinationId: Int) = "detail/$destinationId"
}
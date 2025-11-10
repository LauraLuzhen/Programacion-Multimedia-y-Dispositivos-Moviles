package com.example.t3_jpcnavegacion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.t3_jpcnavegacion.ui.presentation.add.AddDestinationScreen
import com.example.t3_jpcnavegacion.ui.presentation.add.AddDestinationViewModel
import com.example.t3_jpcnavegacion.ui.presentation.detail.DetailScreen
import com.example.t3_jpcnavegacion.ui.presentation.home.HomeScreen
import com.example.t3_jpcnavegacion.ui.presentation.home.HomeViewModel
import com.example.t3_jpcnavegacion.ui.presentation.navigation.ScreenRoutes
import com.example.t3_jpcnavegacion.ui.presentation.settings.SettingsScreen
import com.example.t3_jpcnavegacion.ui.presentation.settings.SettingsViewModel
import com.example.t3_jpcnavegacion.ui.theme.T3_JPCNavegacionTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            T3_JPCNavegacionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}

// NavGraph
@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.HOME
    ) {
        // HOME SCREEN (Ejercicio 1)
        composable(ScreenRoutes.HOME) { backStackEntry ->
            val homeViewModel: HomeViewModel = viewModel()
            HomeScreen(
                viewModel = homeViewModel,
                onNavigateToDetail = { destinationId ->
                    navController.navigate(ScreenRoutes.detailRoute(destinationId))
                },
                onNavigateToAdd = { navController.navigate(ScreenRoutes.ADD) },
                onNavigateToSettings = { navController.navigate(ScreenRoutes.SETTINGS) }
            )
        }

        // DETAIL SCREEN (Ejercicio 2)
        composable(
            route = ScreenRoutes.DETAIL,
            arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val destinationId = backStackEntry.arguments?.getInt("destinationId") ?: 0
            DetailScreen(
                destinationId = destinationId,
                onBack = { navController.popBackStack() }
            )
        }

        // ADD DESTINATION SCREEN (Ejercicio 3)
        composable(ScreenRoutes.ADD) {
            // La función AddDestinationScreen llamará a viewModel() internamente
            // si no le pasas un argumento.
            AddDestinationScreen(
                onBack = { navController.popBackStack() } // Asegúrate de añadir onBack
            )
        }

        // SETTINGS SCREEN (Ejercicio 4)
        composable(ScreenRoutes.SETTINGS) {
            val settingsViewModel: SettingsViewModel = viewModel()
            SettingsScreen(
                viewModel = settingsViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
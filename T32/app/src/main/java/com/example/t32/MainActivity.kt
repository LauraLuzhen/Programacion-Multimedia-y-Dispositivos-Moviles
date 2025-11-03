package com.example.t32

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.t32.ui.presentation.ContactsScreen
import com.example.t32.ui.presentation.FormularioContacto
import com.example.t32.ui.theme.T32Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            T32Theme {
                AppNavigation()
                }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {
        composable("lista") {
            ContactsScreen(navController = navController, modifier = Modifier.padding(all = 12.dp))
        }

        composable("formulario") {
            FormularioContacto(navController = navController)

        }

    }
}
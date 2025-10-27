package com.example.t3boletin1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.t3boletin1.ui.theme.T3Boletin1Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            T3Boletin1Theme {
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
        startDestination = "main"
    ) {
        composable("main") { MainScreen(navController) }
        composable("ejercicio1") { Ejercicio1() }
        composable(route = "ejercicio2") { Ejercicio2() }
        composable(route = "ejercicio3") { Ejercicio3() }
        composable(route = "ejercicio4") { Ejercicio4() }
        composable(route = "ejercicio5") { Ejercicio5() }
        composable(route = "ejercicio6") { Ejercicio6() }
        composable(route = "ejercicio7") { Ejercicio7() }
        composable(route = "ejercicio8") { Ejercicio8() }
        composable(route = "ejercicio9") { Ejercicio9() }
        composable(route = "ejercicio10") { Ejercicio10() }
    }
}

@Composable
fun MainScreen(navController: androidx.navigation.NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("ejercicio1") }
            ) {
                Text(text = "Ir a Ejercicio 1")
            }
            Button(
                onClick = { navController.navigate("ejercicio2") }
            ) {
                Text(text = "Ir a Ejercicio 2")
            }
            Button(
                onClick = { navController.navigate("ejercicio3") }
            ) {
                Text(text = "Ir a Ejercicio 3")
            }
            Button(
                onClick = { navController.navigate("ejercicio4") }
            ) {
                Text(text = "Ir a Ejercicio 4")
            }
            Button(
                onClick = { navController.navigate("ejercicio5") }
            ) {
                Text(text = "Ir a Ejercicio 5")
            }
            Button(
                onClick = { navController.navigate("ejercicio6") }
            ) {
                Text(text = "Ir a Ejercicio 6")
            }
            Button(
                onClick = { navController.navigate("ejercicio7") }
            ) {
                Text(text = "Ir a Ejercicio 7")
            }
            Button(
                onClick = { navController.navigate("ejercicio8") }
            ) {
                Text(text = "Ir a Ejercicio 8")
            }
            Button(
                onClick = { navController.navigate("ejercicio9") }
            ) {
                Text(text = "Ir a Ejercicio 9")
            }
            Button(
                onClick = { navController.navigate("ejercicio10") }
            ) {
                Text(text = "Ir a Ejercicio 10")
            }
        }
    }
}

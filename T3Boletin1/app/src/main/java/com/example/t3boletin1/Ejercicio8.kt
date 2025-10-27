package com.example.t3boletin1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio8() {
    //  Alternador de tema
    var isDarkTheme by remember { mutableStateOf(false) }

    val backgroundColor = if (isDarkTheme) Color.Black else Color.White
    val textColor = if (isDarkTheme) Color.White else Color.Black

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp).background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (isDarkTheme) "Modo Oscuro" else "Modo Claro",
            fontSize = 20.sp,
            color = textColor
        )

        Text(
            text = "Alternar Tema",
            color = textColor,
            fontSize = 18.sp
        )

        Switch(
            checked = isDarkTheme,
            onCheckedChange = { isDarkTheme = it }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio8Preview() {
    Ejercicio8()
}
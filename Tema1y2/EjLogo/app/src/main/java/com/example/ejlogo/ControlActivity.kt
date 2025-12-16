package com.example.ejlogo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ControlActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recuperamos los datos del MainActivity
        val user = intent.getStringExtra("USER")
        val password = intent.getStringExtra("PASSWORD")

        // Por defecto volvemos al MainActivity
        var acceso = Intent(this, MainActivity::class.java)

        if (user == "laura" && password == "123") {
            acceso = Intent(this, WelcomeActivity::class.java)
            acceso.putExtra("USER", user)
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
        }

        startActivity(acceso)
        finish()
    }
}
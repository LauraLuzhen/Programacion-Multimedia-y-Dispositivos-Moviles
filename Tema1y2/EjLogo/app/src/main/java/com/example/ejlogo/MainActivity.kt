package com.example.ejlogo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Asociamos el layout correspondiente
        setContentView(R.layout.activity_main)

        // Conseguimos el contenido de las variables que nos interesan del layout
        val etUser = findViewById<EditText>(R.id.etUser)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnAccess = findViewById<Button>(R.id.btnAccess)

        // Acción del botón
        btnAccess.setOnClickListener {
            val user = etUser.text.toString()
            val password = etPassword.text.toString()

            // Enviamos los datos al ControlActivity
            val intent = Intent(this, ControlActivity::class.java)
            intent.putExtra("USER", user)
            intent.putExtra("PASSWORD", password)
            startActivity(intent)
        }
    }
}
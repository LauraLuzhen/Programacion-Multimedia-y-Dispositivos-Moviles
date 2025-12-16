package com.example.ejlogo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Asociamos el layout
        setContentView(R.layout.activity_welcome)

        val tvContent = findViewById<TextView>(R.id.tvContent)

        // Recuperamos el usuairo del control
        val user = intent.getStringExtra("USER")

        tvContent.text = "Bienvenido, $user"
    }
}
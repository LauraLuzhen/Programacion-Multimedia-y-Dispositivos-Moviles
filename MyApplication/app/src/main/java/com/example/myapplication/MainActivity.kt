package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ciclo", "onCreate(A) creado")
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bAcceder.text = "Pulsa aquí"

        binding.bAcceder.setOnClickListener {
            val nombreUsuario = binding.plainUsuario.text.toString()
            val contraseñaUsuario = binding.plainContraseA.text.toString()

            if (nombreUsuario == "Laura" && contraseñaUsuario == "1234") {
                val intent = Intent(this, WelcomeActivity::class.java)

                intent.putExtra("EXTRA_USUARIO", nombreUsuario)
                intent.putExtra("EXTRA_CONTRASEÑA", contraseñaUsuario)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("ciclo", "onStop(A) llamado - La Activity ya no es visible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ciclo", "onRestart(A) llamado - Volviendo de estar 'stopped'")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("ciclo", "onDestroy(A) llamado - La Activity está siendo destruida")
    }
    override fun onPause() {
        super.onPause()
        Log.d("ciclo", "onPause(A) llamado - Otra Activity toma el foco")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ciclo", "onResume(A) llamado - ¡La Activity es visible y activa!")
        getString(R.string.toast_actividad_b)
    }

    override fun onStart() {
        super.onStart()
        Log.d("ciclo", "onStart(A) llamado")

    }
}


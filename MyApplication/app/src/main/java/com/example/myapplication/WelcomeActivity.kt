package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ciclo", "onCreate(B) creado")
        enableEdgeToEdge()

        val binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getStringExtra("EXTRA_USUARIO")

        binding.textoBienvenida.text = "¡Bienvenido, $usuario!"

        val contenidoTexto = binding.buscar.text.toString()

        binding.bNavegador.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = "https://www.google.com/search?q=$contenidoTexto".toUri()

            startActivity(intent)
        }

        binding.bTelefono.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, "tel:$contenidoTexto".toUri())
            startActivity(intent)
        }

        binding.bMensaje.setOnClickListener {
            val smsIntent = Intent(Intent.ACTION_VIEW)
            smsIntent.data = Uri.parse("smsto:" + contenidoTexto) // número escrito en el EditText
            smsIntent.putExtra("sms_body", "Hola desde mi app") // texto opcional
            startActivity(smsIntent)
        }

        binding.bCompartir.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, contenidoTexto) // texto escrito en el EditText
            startActivity(Intent.createChooser(shareIntent, "Compartir con..."))
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("ciclo", "onStop(B) llamado - La Activity ya no es visible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ciclo", "onRestart(B) llamado - Volviendo de estar 'stopped'")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("ciclo", "onDestroy(B) llamado - La Activity está siendo destruida")
    }
    override fun onPause() {
        super.onPause()
        Log.d("ciclo", "onPause(B) llamado - Otra Activity toma el foco")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ciclo", "onResume(B) llamado - ¡La Activity es visible y activa!")
        getString(R.string.toast_actividad_b)
    }

    override fun onStart() {
        super.onStart()
        Log.d("ciclo", "onStart(B) llamado")

    }
}
package com.example.myapplication

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //Uso la extensión de funcion parcelable para obtener un objeto parcelable de un intent
        val persona: Persona? = intent.parcelable("persona")

        if (persona != null) {
            binding.ivFotoPersona.setImageResource(persona.imagen ?: R.drawable.imagen_por_defecto)
            binding.tvNombre.text = persona.nombre
            binding.tvCorreo.text = persona.correo
            binding.tvTelefono.text = persona.telefono
        }

    }
    //La extension de funcion parcelable utilizara el metodo adecuado segun la version de la API
    inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
        SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
    }

    inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
        SDK_INT >= 33 -> getParcelable(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelable(key) as? T
    }
}
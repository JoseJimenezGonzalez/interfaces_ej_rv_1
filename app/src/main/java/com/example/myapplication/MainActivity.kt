package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterRecyclerView: AdapterRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPersonas = mutableListOf(
            Persona(
                imagen = R.drawable.ada_lovelace,
                nombre = "Ada Lovelace",
                correo = "ada@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.stephen_hawking,
                nombre = "Stephen Hawking",
                correo = "hawking@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.sir_isaac_newton,
                nombre = "Sir Isaac Newton",
                correo = "newton@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.gauss,
                nombre = "Friedrich Gauss",
                correo = "gauss@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.alan_turing,
                nombre = "Alan Turing",
                correo = "turing@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.euler,
                nombre = "Leonhard Euler",
                correo = "euler@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.werner_heisenberg,
                nombre = "Werner Heisenberg",
                correo = "heisenberg@gmail.com",
                telefono = "666666666",
            ),

            Persona(
                imagen = R.drawable.nietzsche,
                nombre = "Nietzsche",
                correo = "nietzsche@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.javier_santaolalla,
                nombre = "Javier Santaolalla",
                correo = "javi@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.saenz,
                nombre = "Eduardo Saenz",
                correo = "saenz@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.evariste_galois,
                nombre = "Galois",
                correo = "galois@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.einstein,
                nombre = "Albert Einstein",
                correo = "einstein@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.oppenheimer,
                nombre = "Oppenheimer",
                correo = "oppenheimer@gmail.com",
                telefono = "666666666",
            ),
        )

        //adapterRecyclerView = AdapterRecyclerView(listaPersonas): Se crea una instancia del adaptador
        //personalizado AdapterRecyclerView, que se espera que tenga una lista de objetos
        //Persona (listaPersonas) como su conjunto de datos.
        adapterRecyclerView = AdapterRecyclerView(listaPersonas, this)
        //apply permite realizar múltiples configuraciones en binding.rv sin tener que repetir binding.rv.
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRecyclerView
        }
    }

    override fun onItemClick(persona: Persona) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("persona", persona)
        startActivity(intent)
    }
}
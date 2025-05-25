package com.example.appclinicarobles

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appclinicarobles.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener {
            val nombre = binding.editNombre.text.toString().trim()
            val dni = binding.editDni.text.toString().trim()

            if (nombre.isEmpty()) {
                binding.editNombre.error = "Por favor ingrese su nombre"
                return@setOnClickListener
            }

            if (dni.isEmpty()) {
                binding.editDni.error = "Por favor ingrese su DNI"
                return@setOnClickListener
            }

            // Opcional: validar que DNI tenga cierta longitud, ej:
            if (dni.length < 6) {
                binding.editDni.error = "Ingrese un DNI válido"
                return@setOnClickListener
            }

            val intent = Intent(this, SpecialtiesActivity::class.java)
            intent.putExtra("nombrePaciente", nombre)
            intent.putExtra("dniPaciente", dni)
            startActivity(intent)
        }
    }
}

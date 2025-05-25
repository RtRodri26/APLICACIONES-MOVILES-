package com.example.appclinicarobles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appclinicarobles.databinding.ActivityDetailBinding
import com.example.appclinicarobles.model.Specialty

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener el objeto enviado
        val specialty = intent.getSerializableExtra("specialty") as? Specialty

        // Verificar que no sea nulo
        if (specialty != null) {
            binding.tvClinica.text = "Clínica Robles"
            binding.tvEspecialidad.text = specialty.nombre         // nombre es la especialidad
            binding.tvNombre.text = "Dr(a). ${specialty.doctor}"   // doctor es el nombre del doctor
            binding.ivIcono.setImageResource(specialty.icono)
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}

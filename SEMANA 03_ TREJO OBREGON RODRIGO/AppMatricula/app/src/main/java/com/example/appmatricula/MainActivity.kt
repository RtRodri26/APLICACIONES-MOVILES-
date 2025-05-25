package com.example.appmatricula

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

data class Alumno(val codigo: String, val nombre: String, val correo: String, val direccion: String)

class MainActivity : AppCompatActivity() {

    private val listaAlumnos = ArrayList<Alumno>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCodigo = findViewById<EditText>(R.id.etCodigo)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val tvListaAlumnos = findViewById<TextView>(R.id.tvListaAlumnos)

        btnRegistrar.setOnClickListener {
            val codigo = etCodigo.text.toString()
            val nombre = etNombre.text.toString()
            val correo = etCorreo.text.toString()
            val direccion = etDireccion.text.toString()

            if (codigo.isEmpty() || nombre.isEmpty() || correo.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val alumno = Alumno(codigo, nombre, correo, direccion)
                listaAlumnos.add(alumno)
                mostrarLista(tvListaAlumnos)

                // Limpiar campos
                etCodigo.text.clear()
                etNombre.text.clear()
                etCorreo.text.clear()
                etDireccion.text.clear()
            }
        }
    }

    private fun mostrarLista(tv: TextView) {
        var texto = "Lista de alumnos registrados:\n"
        for ((i, alumno) in listaAlumnos.withIndex()) {
            texto += "${i + 1}. ${alumno.codigo} - ${alumno.nombre} - ${alumno.correo} - ${alumno.direccion}\n"
        }
        tv.text = texto
    }
}

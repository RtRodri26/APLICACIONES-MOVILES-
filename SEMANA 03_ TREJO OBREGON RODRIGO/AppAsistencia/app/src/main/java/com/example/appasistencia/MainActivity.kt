package com.example.appasistencia

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

data class Asistencia(val codigo: String, val nombre: String, val fechaHora: String)

class MainActivity : AppCompatActivity() {

    private val listaAsistencias = ArrayList<Asistencia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCodigo = findViewById<EditText>(R.id.etCodigo)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val tvLista = findViewById<TextView>(R.id.tvLista)

        btnRegistrar.setOnClickListener {
            val codigo = etCodigo.text.toString()
            val nombre = etNombre.text.toString()

            if (codigo.isEmpty() || nombre.isEmpty()) {
                Toast.makeText(this, "Completa ambos campos", Toast.LENGTH_SHORT).show()
            } else {
                val fechaHora = obtenerFechaHoraActual()
                val asistencia = Asistencia(codigo, nombre, fechaHora)
                listaAsistencias.add(asistencia)

                mostrarAsistencias(tvLista)

                // Limpiar campos
                etCodigo.text.clear()
                etNombre.text.clear()
            }
        }
    }

    private fun obtenerFechaHoraActual(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        return sdf.format(Date())
    }

    private fun mostrarAsistencias(tv: TextView) {
        var texto = "Asistencias registradas:\n"
        for ((i, asistencia) in listaAsistencias.withIndex()) {
            texto += "${i + 1}. ${asistencia.codigo} - ${asistencia.nombre} - ${asistencia.fechaHora}\n"
        }
        tv.text = texto
    }
}

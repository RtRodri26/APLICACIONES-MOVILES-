package com.example.appordenamiento

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val et4 = findViewById<EditText>(R.id.et4)
        val et5 = findViewById<EditText>(R.id.et5)
        val btnOrdenar = findViewById<Button>(R.id.btnOrdenar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnOrdenar.setOnClickListener {
            try {
                val numeros = listOf(
                    et1.text.toString().toInt(),
                    et2.text.toString().toInt(),
                    et3.text.toString().toInt(),
                    et4.text.toString().toInt(),
                    et5.text.toString().toInt()
                ).toMutableList()

                // Método burbuja
                for (i in 0 until numeros.size - 1) {
                    for (j in 0 until numeros.size - i - 1) {
                        if (numeros[j] > numeros[j + 1]) {
                            val temp = numeros[j]
                            numeros[j] = numeros[j + 1]
                            numeros[j + 1] = temp
                        }
                    }
                }

                tvResultado.text = "Ordenado: ${numeros.joinToString(", ")}"

            } catch (e: Exception) {
                Toast.makeText(this, "Por favor ingresa todos los números", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

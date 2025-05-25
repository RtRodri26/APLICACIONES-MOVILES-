package com.example.appcalculadora

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val num3 = findViewById<EditText>(R.id.num3)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)

        fun getInputs(): Triple<Double, Double, Double>? {
            return try {
                val n1 = num1.text.toString().toDouble()
                val n2 = num2.text.toString().toDouble()
                val n3 = num3.text.toString().toDouble()
                Triple(n1, n2, n3)
            } catch (e: Exception) {
                Toast.makeText(this, "Ingresa números válidos", Toast.LENGTH_SHORT).show()
                null
            }
        }

        btnSumar.setOnClickListener {
            getInputs()?.let {
                val result = it.first + it.second + it.third
                tvResultado.text = "Resultado: $result"
            }
        }

        btnRestar.setOnClickListener {
            getInputs()?.let {
                val result = it.first - it.second - it.third
                tvResultado.text = "Resultado: $result"
            }
        }

        btnMultiplicar.setOnClickListener {
            getInputs()?.let {
                val result = it.first * it.second * it.third
                tvResultado.text = "Resultado: $result"
            }
        }

        btnDividir.setOnClickListener {
            getInputs()?.let {
                if (it.second != 0.0 && it.third != 0.0) {
                    val result = it.first / it.second / it.third
                    tvResultado.text = "Resultado: $result"
                } else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

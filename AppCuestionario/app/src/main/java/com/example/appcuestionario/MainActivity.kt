package com.example.appcuestionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.et_name)
        val btnStart = findViewById<Button>(R.id.btn_start)

        btnStart.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
                finish()
            } else {
                etName.error = "Por favor ingresa tu nombre"
            }
        }
    }
}

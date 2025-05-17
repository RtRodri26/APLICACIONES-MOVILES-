package com.example.appcuestionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvUserName = findViewById<TextView>(R.id.tv_user_name)
        val tvScore = findViewById<TextView>(R.id.tv_score_result)
        val btnFinish = findViewById<Button>(R.id.btn_finish)

        val name = intent.getStringExtra("USER_NAME") ?: "Desconocido"
        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)

        tvUserName.text = getString(R.string.result_username_placeholder, name)
        tvScore.text = getString(R.string.result_score_placeholder, score, totalQuestions)

        btnFinish.setOnClickListener {
            // Regresa a la pantalla principal
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}
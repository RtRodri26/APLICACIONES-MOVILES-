package com.example.appcuestionario


data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: Int
)

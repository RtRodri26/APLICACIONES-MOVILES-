package com.example.loginapp

data class User(
    val email: String,
    val password: String,
    val name: String? = null
)
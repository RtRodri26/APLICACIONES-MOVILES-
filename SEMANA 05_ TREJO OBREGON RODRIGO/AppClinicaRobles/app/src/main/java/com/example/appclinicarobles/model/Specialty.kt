package com.example.appclinicarobles.model


import java.io.Serializable

data class Specialty(
    val nombre: String,
    val doctor: String,
    val horario: String,
    val icono: Int
) : Serializable

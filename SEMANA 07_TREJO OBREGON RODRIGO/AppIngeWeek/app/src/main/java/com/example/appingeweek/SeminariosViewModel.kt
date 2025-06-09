package com.example.appingeweek


import androidx.lifecycle.ViewModel

class SeminariosViewModel : ViewModel() {

    fun getSeminarios(): List<String> {
        // Retorna la lista de seminarios
        return listOf(
            "Seminario sobre Energía Renovable - 9:00 AM",
            "Seminario sobre Inteligencia Artificial - 11:00 AM"
        )
    }
}

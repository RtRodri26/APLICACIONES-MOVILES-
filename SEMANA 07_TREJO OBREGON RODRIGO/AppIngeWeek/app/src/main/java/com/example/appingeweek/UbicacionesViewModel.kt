package com.example.appingeweek


import androidx.lifecycle.ViewModel

class UbicacionesViewModel : ViewModel() {

    fun getUbicaciones(): List<String> {
        // Retorna la lista de ubicaciones
        return listOf(
            "Auditorio Biblioteca Central - 9:00 AM",
            "Complejo Deportivo UNS - 3:00 PM"
        )
    }
}

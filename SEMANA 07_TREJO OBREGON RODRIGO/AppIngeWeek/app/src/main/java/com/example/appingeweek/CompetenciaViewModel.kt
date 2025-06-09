package com.example.appingeweek


import androidx.lifecycle.ViewModel

class CompetenciaViewModel : ViewModel() {

    fun getCompetencias(): List<String> {
        // Retorna la lista de competencias
        return listOf(
            "Competencia de Fútbol - 3:00 PM",
            "Competencia de Vóley - 4:00 PM"
        )
    }
}

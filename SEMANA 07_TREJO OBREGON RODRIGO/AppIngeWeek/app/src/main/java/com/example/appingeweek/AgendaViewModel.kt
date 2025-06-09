package com.example.appingeweek

import androidx.lifecycle.ViewModel

class AgendaViewModel : ViewModel() {

    fun getAgenda(): List<String> {
        // Retorna la lista de eventos de la agenda
        return listOf(
            "Ceremonia de Inauguración - 9:00 AM",
            "Conferencia sobre el Ingeniero como Agente de Cambio - 10:00 AM",
            "Competencia de Fútbol - 3:00 PM"
        )
    }
}

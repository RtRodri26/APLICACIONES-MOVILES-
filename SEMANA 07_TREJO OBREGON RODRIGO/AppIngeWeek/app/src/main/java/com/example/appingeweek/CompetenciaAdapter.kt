package com.example.appingeweek

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CompetenciaAdapter(private val competenciaList: List<String>) : RecyclerView.Adapter<CompetenciaAdapter.CompetenciaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetenciaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_competencia, parent, false)
        return CompetenciaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompetenciaViewHolder, position: Int) {
        holder.bind(competenciaList[position])
    }

    override fun getItemCount(): Int = competenciaList.size

    inner class CompetenciaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Usamos findViewById para enlazar la vista correctamente
        private val tvCompetencia: TextView = view.findViewById(R.id.tvCompetencia)

        fun bind(competencia: String) {
            tvCompetencia.text = competencia
        }
    }
}

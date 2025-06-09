package com.example.appingeweek

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SeminariosAdapter(private val seminariosList: List<String>) : RecyclerView.Adapter<SeminariosAdapter.SeminariosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeminariosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_seminarios, parent, false)
        return SeminariosViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeminariosViewHolder, position: Int) {
        holder.bind(seminariosList[position])
    }

    override fun getItemCount(): Int = seminariosList.size

    inner class SeminariosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Usamos findViewById para enlazar la vista correctamente
        private val tvSeminario: TextView = view.findViewById(R.id.tvSeminario)

        fun bind(seminario: String) {
            tvSeminario.text = seminario
        }
    }
}

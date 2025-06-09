package com.example.appingeweek

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UbicacionesAdapter(private val ubicacionesList: List<String>) : RecyclerView.Adapter<UbicacionesAdapter.UbicacionesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UbicacionesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ubicaciones, parent, false)
        return UbicacionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: UbicacionesViewHolder, position: Int) {
        holder.bind(ubicacionesList[position])
    }

    override fun getItemCount(): Int = ubicacionesList.size

    inner class UbicacionesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Usamos findViewById para enlazar la vista correctamente
        private val tvUbicacion: TextView = view.findViewById(R.id.tvUbicacion)

        fun bind(ubicacion: String) {
            tvUbicacion.text = ubicacion
        }
    }
}

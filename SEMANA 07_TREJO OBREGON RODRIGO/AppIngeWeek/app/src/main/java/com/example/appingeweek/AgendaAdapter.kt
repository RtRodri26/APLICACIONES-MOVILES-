package com.example.appingeweek



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AgendaAdapter(private val agendaList: List<String>) : RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_agenda, parent, false)
        return AgendaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgendaViewHolder, position: Int) {
        holder.bind(agendaList[position])
    }

    override fun getItemCount(): Int = agendaList.size

    inner class AgendaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvEvent: TextView = view.findViewById(R.id.tvEvent)  // Usamos findViewById para enlazar la vista

        fun bind(event: String) {
            tvEvent.text = event
        }
    }
}

package com.example.appclinicarobles.adapter



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appclinicarobles.databinding.ItemSpecialtyBinding
import com.example.appclinicarobles.model.Specialty

class SpecialtyAdapter(
    private val list: List<Specialty>,
    private val onClick: (Specialty) -> Unit
) : RecyclerView.Adapter<SpecialtyAdapter.SpecialtyViewHolder>() {

    inner class SpecialtyViewHolder(val binding: ItemSpecialtyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Specialty) {
            binding.tvNombre.text = item.nombre
            binding.tvDoctor.text = item.doctor
            binding.tvHorario.text = item.horario
            binding.ivIcono.setImageResource(item.icono)

            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
        val binding = ItemSpecialtyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpecialtyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

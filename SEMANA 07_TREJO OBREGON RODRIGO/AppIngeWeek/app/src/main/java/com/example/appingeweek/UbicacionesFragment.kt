package com.example.appingeweek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UbicacionesFragment : Fragment() {

    private lateinit var ubicacionesViewModel: UbicacionesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var ubicacionesAdapter: UbicacionesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_ubicaciones, container, false)

        ubicacionesViewModel = ViewModelProvider(this).get(UbicacionesViewModel::class.java)

        recyclerView = root.findViewById(R.id.recyclerViewUbicaciones)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        ubicacionesAdapter = UbicacionesAdapter(ubicacionesViewModel.getUbicaciones())
        recyclerView.adapter = ubicacionesAdapter

        return root
    }
}

package com.example.appingeweek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AgendaFragment : Fragment() {

    private lateinit var agendaViewModel: AgendaViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var agendaAdapter: AgendaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_agenda, container, false)

        agendaViewModel = ViewModelProvider(this).get(AgendaViewModel::class.java)

        recyclerView = root.findViewById(R.id.recyclerViewAgenda)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        agendaAdapter = AgendaAdapter(agendaViewModel.getAgenda())
        recyclerView.adapter = agendaAdapter

        return root
    }
}


package com.example.appingeweek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompetenciaFragment : Fragment() {

    private lateinit var competenciaViewModel: CompetenciaViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var competenciaAdapter: CompetenciaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_competencia, container, false)

        competenciaViewModel = ViewModelProvider(this).get(CompetenciaViewModel::class.java)

        recyclerView = root.findViewById(R.id.recyclerViewCompetencia)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        competenciaAdapter = CompetenciaAdapter(competenciaViewModel.getCompetencias())
        recyclerView.adapter = competenciaAdapter

        return root
    }
}

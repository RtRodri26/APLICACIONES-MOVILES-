package com.example.appingeweek


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SeminariosFragment : Fragment() {

    private lateinit var seminariosViewModel: SeminariosViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var seminariosAdapter: SeminariosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_seminarios, container, false)

        seminariosViewModel = ViewModelProvider(this).get(SeminariosViewModel::class.java)

        recyclerView = root.findViewById(R.id.recyclerViewSeminarios)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        seminariosAdapter = SeminariosAdapter(seminariosViewModel.getSeminarios())
        recyclerView.adapter = seminariosAdapter

        return root
    }
}

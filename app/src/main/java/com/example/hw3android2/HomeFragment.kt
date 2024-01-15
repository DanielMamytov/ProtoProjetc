package com.example.hw3android2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3android2.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private val noteAdapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        siriliziaciy()
    }

    private fun siriliziaciy() {
        noteAdapter.setNoteList(
            mutableListOf(
                HomeModel("Нужно сделать:", "Работы с проектом,сделать домашку,убраться и..", "6 июня\n 17:10"),
                HomeModel("Нужно сделать:", "Работы с проектом,сделать домашку,убраться и..", "6 июня\n 17:10"),
                HomeModel("Нужно сделать:", "Работы с проектом,сделать домашку,убраться и..", "6 июня\n 17:10")
                )
            )
        binding.rvPanel.adapter = noteAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
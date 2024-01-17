package com.example.hw3android2.noteapp.data.local.room.dao.entities.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Dao
import com.example.hw3android2.noteapp.data.local.room.dao.entities.ui.adapters.HomeAdapter
import com.example.hw3android2.HomeModel
import com.example.hw3android2.R
import com.example.hw3android2.databinding.FragmentHomeBinding
import com.example.utils.App

@Dao
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
        navigateToAddFragment()
        getNotesFromRoom()

    }

    private fun getNotesFromRoom() {
       val noteList = App.db.noteDao().getAllNotes()
       noteAdapter.setNoteList(noteList)
    }

    private fun navigateToAddFragment() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment2)
        }
    }

    private fun siriliziaciy() {
        binding.rvPanel.adapter = noteAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
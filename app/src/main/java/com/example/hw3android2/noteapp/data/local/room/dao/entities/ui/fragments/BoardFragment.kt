package com.example.hw3android2.noteapp.data.local.room.dao.entities.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3android2.R
import com.example.hw3android2.noteapp.data.local.room.dao.entities.ui.adapters.RacersAdapter
import com.example.hw3android2.databinding.FragmentBoardBinding

class BoardFragment : Fragment(R.layout.fragment_board) {

    private var _binding:FragmentBoardBinding? = null
    private val binding:FragmentBoardBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = RacersAdapter(this)
        binding.dotsIndicator.setViewPager2(binding.viewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
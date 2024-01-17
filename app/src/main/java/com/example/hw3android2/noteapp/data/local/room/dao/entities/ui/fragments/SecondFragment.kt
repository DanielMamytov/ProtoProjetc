package com.example.hw3android2.noteapp.data.local.room.dao.entities.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.utils.PreferencesHelper
import com.example.hw3android2.R
import com.example.hw3android2.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!
    private val preferencesHelper: PreferencesHelper by lazy {
        PreferencesHelper(context ?: requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSkipClick()
    }

    private fun onSkipClick() {
        binding.btnScip.setOnClickListener {
            preferencesHelper.isShownOnBoard = true
            findNavController().navigate(R.id.action_boardFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.hw3android2.noteapp.ui.fragments.library

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hw3android2.R
import com.example.hw3android2.databinding.FragmentLibraryBinding

class LibraryFragment : Fragment(R.layout.fragment_library) {

    private val binding by viewBinding(FragmentLibraryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
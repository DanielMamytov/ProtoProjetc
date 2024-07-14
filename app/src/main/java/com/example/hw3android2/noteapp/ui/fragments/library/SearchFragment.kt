package com.example.hw3android2.noteapp.ui.fragments.library

import NotesAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw3android2.R
import com.example.hw3android2.databinding.FragmentSearchBinding
import com.example.hw3android2.noteapp.data.local.room.dao.entities.NotePro

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: NotesAdapter

    // Sample data
    private val notesList = listOf(
        NotePro(
            title = "Руководство войсковой части 7705",
            description = "Lorem ipsum dolor sit amet consectetur. Lorem ipsum..."
        ),
        NotePro(
            title = "Note 2",
            description = "This is the description for Note 2."
        ),
        NotePro(
            title = "Я же говорил это легко",
            description = "This is the description for Note 3."
        )
        // Add more notes as needed
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        adapter = NotesAdapter()
        initialize()
        searchCharacterListener()
    }

    private fun initialize() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@SearchFragment.adapter
        }
        // Initially show all notes
        adapter.submitList(notesList)
    }

    private fun searchCharacterListener() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed before text changes
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    searchCharacter(s.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // No action needed after text changes
            }
        })
    }

    private fun searchCharacter(query: String) {
        val filteredList = notesList.filter { note ->
            note.title.contains(query, ignoreCase = true) ||
                    note.description.contains(query, ignoreCase = true)
        }
        adapter.updateSearchQuery(query)
        adapter.submitList(filteredList)
    }
}

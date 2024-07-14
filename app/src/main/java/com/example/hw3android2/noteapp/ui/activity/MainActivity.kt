package com.example.hw3android2.noteapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.hw3android2.R
import com.example.hw3android2.databinding.ActivityMainBinding
import com.example.utils.PreferencesHelper

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    private val preferencesHelper: PreferencesHelper by lazy {
        PreferencesHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation(savedInstanceState)
    }

    private fun setupNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main_activity) as NavHostFragment
        val navController = navHostFragment.navController

        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
            if (preferencesHelper.isShownOnBoard) {
                navGraph.setStartDestination(R.id.searchFragment)
            } else {
                navGraph.setStartDestination(R.id.searchFragment)
            }

            navController.graph = navGraph
        }
    }
}
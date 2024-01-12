package com.example.hw3android2

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class RacersAdapter(fragment: BoardFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
        0 -> FirstFragment()
        1 -> SecondFragment()
        else -> ThirdFragment()
        }
    }
}

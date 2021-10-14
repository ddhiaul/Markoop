package com.aulia.dean.markoop.genre

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class GenreAdapter (frame : FragmentManager) : FragmentPagerAdapter(frame) {

    private val pages = listOf(
        AllGenreFragment(),
        RomanceFragment(),
        MysteryFragment(),
        HorrorFragment(),
        FantasyFragment()
    )

    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "All"
            1 -> "Romance"
            2 -> "Mystery"
            3 -> "Horror"
            else -> "Fantasy"
        }
    }
}
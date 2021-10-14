package com.finalproject.markoop.genre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.finalproject.dean.markoop.R
import kotlinx.android.synthetic.main.fragment_genre.*

class GenreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpager_genre.adapter = GenreAdapter(fragmentManager as FragmentManager)

        tablayout_genre.setupWithViewPager(viewpager_genre)
    }
}
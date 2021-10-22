package com.finalproject.markoop.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.R
import com.finalproject.markoop.genre.GenreModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList

class HomeFragment : Fragment() {
    private val model = ArrayList<GenreModel>()

    companion object {
        fun defaultFragment() : HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.addAll(getListNovel())
        rv_recomendation.setHasFixedSize(true)
        rv_best_fantasy.setHasFixedSize(true)

        showRecomendedList()
        showBestFantasyList()
    }

    private fun showRecomendedList() {
//        adapter = HomeAdapter { showSelected(it) }
//        adapter.notifyDataSetChanged()
        rv_recomendation.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_recomendation.adapter = HomeAdapter(model)
    }

    private fun showBestFantasyList() {
        rv_best_fantasy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_best_fantasy.adapter = HomeAdapter(model)
    }

    private fun getListNovel(): ArrayList<GenreModel> {
        val novelTitle = resources.getStringArray(R.array.novel_title)
        val novelGenre = resources.getStringArray(R.array.novel_genre)
        val novelSynopsis = resources.getStringArray(R.array.novel_synopsis)
        val novelAuthor = resources.getStringArray(R.array.novel_author)

        val model = ArrayList<GenreModel>()

        for (position in novelTitle.indices){
            val novel = GenreModel(
                novelTitle[position],
                novelGenre[position],
                novelSynopsis[position],
                novelAuthor[position],
            )
            model.add(novel)
        }
        return model
    }
}
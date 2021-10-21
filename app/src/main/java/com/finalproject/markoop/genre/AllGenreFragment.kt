package com.finalproject.markoop.genre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.R
import kotlinx.android.synthetic.main.fragment_all_genre.*

class AllGenreFragment : Fragment() {
    private val listGenre = ArrayList<GenreModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_genre, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_all_genre.setHasFixedSize(true)
        listGenre.addAll(getListGenre())

        showGenreList()
    }

    private fun showGenreList() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_all_genre.layoutManager = layoutManager
        rv_all_genre.adapter = NovelListAdapter(listGenre)
    }

    private fun getListGenre(): Collection<GenreModel> {
        val novelTitle = resources.getStringArray(R.array.novel_title)
        val novelGenre = resources.getStringArray(R.array.novel_genre)
        val novelSynopsis = resources.getStringArray(R.array.novel_synopsis)
        val novelAuthor = resources.getStringArray(R.array.novel_author)

        val listGenre = ArrayList<GenreModel>()

        for (position in novelTitle.indices){
            val novel = GenreModel(
                novelTitle[position],
                novelGenre[position],
                novelSynopsis[position],
                novelAuthor[position],
            )
            listGenre.add(novel)
        }
        return listGenre
    }


}
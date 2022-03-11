package com.finalproject.markoop.genre

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.detail.DetailNovelActivity
import com.finalproject.markoop.R
import com.finalproject.markoop.adapter.NovelListAdapter
import com.finalproject.markoop.model.GenreModel
import kotlinx.android.synthetic.main.fragment_all_genre.*

class AllGenreFragment : Fragment() {
    private val listGenre = ArrayList<GenreModel>()
    private lateinit var allGenreAdapater : NovelListAdapter

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
        allGenreAdapater = NovelListAdapter { showDetails(it) }
        allGenreAdapater.notifyDataSetChanged()
        allGenreAdapater.setData(getListGenre())
        rv_all_genre.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_all_genre.adapter = allGenreAdapater
        rv_all_genre.setHasFixedSize(true)
    }

    private fun showDetails(it: GenreModel) {
        val intent = Intent(context, DetailNovelActivity::class.java)
        intent.putExtra(DetailNovelActivity.KEY_ALL_GENRE, it)
        startActivity(intent)
    }

    private fun getListGenre(): ArrayList<GenreModel> {
        val novelCover = resources.obtainTypedArray(R.array.all_genre_cover)
        val novelTitle = resources.getStringArray(R.array.all_genre_title)
        val novelGenre = resources.getStringArray(R.array.all_genre_genre)
        val novelSynopsis = resources.getStringArray(R.array.all_genre_synopsis)
        val novelAuthor = resources.getStringArray(R.array.all_genre_author)
        val episodeTitle = resources.getStringArray(R.array.episode_title)
        val releaseDate = resources.getStringArray(R.array.release_date)
        val headline = resources.getStringArray(R.array.headline)
        val content = resources.getStringArray(R.array.content)

        val listGenre = ArrayList<GenreModel>()

        for (position in novelTitle.indices){
            val novel = GenreModel(
                novelCover.getResourceId(position, -1),
                novelTitle[position],
                novelGenre[position],
                novelSynopsis[position],
                novelAuthor[position],
                episodeTitle[position],
                releaseDate[position],
                headline[position],
                content[position]
            )
            listGenre.add(novel)
        }
        return listGenre
    }




}
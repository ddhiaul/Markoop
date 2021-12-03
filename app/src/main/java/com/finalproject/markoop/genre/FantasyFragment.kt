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
import com.finalproject.markoop.adapter.FantasyAdapter
import com.finalproject.markoop.detail.DetailFantasyActivity
import com.finalproject.markoop.model.FantasyModel
import kotlinx.android.synthetic.main.fragment_fantasy.*

class FantasyFragment : Fragment() {

    private val listFantasy = ArrayList<FantasyModel>()
    private lateinit var fantasyAdapter: FantasyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fantasy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_fantasy.setHasFixedSize(true)
        listFantasy.addAll(getListGenre())

        showGenreList()
    }

    private fun showGenreList() {
        fantasyAdapter = FantasyAdapter { showDetails(it) }
        fantasyAdapter.notifyDataSetChanged()
        fantasyAdapter.setData(getListGenre())
        rv_fantasy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_fantasy.adapter = fantasyAdapter
        rv_fantasy.setHasFixedSize(true)
    }

    private fun showDetails(it: FantasyModel) {
        val intent = Intent(context, DetailFantasyActivity::class.java)
        intent.putExtra(DetailFantasyActivity.KEY_ALL_FANTASY, it)
        startActivity(intent)
    }

    private fun getListGenre(): ArrayList<FantasyModel> {
        val fantasyCover = resources.obtainTypedArray(R.array.fantasy_cover)
        val fantasyTitle = resources.getStringArray(R.array.fantasy_title)
        val fantasyGenre = resources.getStringArray(R.array.fantasy_genre)
        val fantasySynopsis = resources.getStringArray(R.array.fantasy_synopsis)
        val fantasyAuthor = resources.getStringArray(R.array.fantasy_author)
        val fantasyEpisodeTitle = resources.getStringArray(R.array.fantasy_episode_title)
        val fantasyReleaseDate = resources.getStringArray(R.array.fantasy_release_date)
        val fantasyHeadline = resources.getStringArray(R.array.fantasy_headline)
        val fantasyContent = resources.getStringArray(R.array.fantasy_content)

        val listGenre = ArrayList<FantasyModel>()

        for (position in fantasyTitle.indices){
            val novel = FantasyModel(
                fantasyCover.getResourceId(position, -1),
                fantasyTitle[position],
                fantasyGenre[position],
                fantasySynopsis[position],
                fantasyAuthor[position],
                fantasyEpisodeTitle[position],
                fantasyReleaseDate[position],
                fantasyHeadline[position],
                fantasyContent[position]
            )
            listGenre.add(novel)
        }
        return listGenre
    }

}
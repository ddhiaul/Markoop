package com.finalproject.markoop.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.episode.adapter.EpisodeAdapter
import com.finalproject.markoop.R
import com.finalproject.markoop.adapter.FantasyAdapter
import com.finalproject.markoop.adapter.HorrorAdapter
import com.finalproject.markoop.episode.activity.EpisodeActivity
import com.finalproject.markoop.episode.activity.FantasyEpisodeActivity
import com.finalproject.markoop.episode.activity.MysteryEpisodeActivity
import com.finalproject.markoop.episode.adapter.FantasyEpisodeAdapter
import com.finalproject.markoop.episode.adapter.HorrorEpisodeAdapter
import com.finalproject.markoop.episode.adapter.MysteryEpisodeAdapter
import com.finalproject.markoop.model.FantasyModel
import com.finalproject.markoop.model.HorrorModel
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.activity_detail_fantasy.*
import kotlinx.android.synthetic.main.activity_detail_horror.*
import kotlinx.android.synthetic.main.activity_detail_mystery.*
import kotlinx.android.synthetic.main.activity_detail_novel.*

class DetailFantasyActivity : AppCompatActivity() {

    private val listFantasyEpisode = ArrayList<FantasyModel>()
    private lateinit var fantasyEpisodeAdapter: FantasyEpisodeAdapter

    companion object{
        const val  KEY_ALL_FANTASY = "key_all_fantasy"
    }

    private var model : FantasyModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_fantasy)

        model = intent.getParcelableExtra(KEY_ALL_FANTASY)

        img_detail_novel.setImageResource(model?.fantasyCover!!)
        tv_detail_novel_title.setText(model?.fantasyTitle)
        tv_detail_author.setText(model?.fantasyAuthor)
        tv_detail_genre.setText(model?.fantasyGenre)

        rv_episode_fantasy.setHasFixedSize(true)
        listFantasyEpisode.addAll(getlistEpisode())

        showEpisodeList()

    }

    private fun showEpisodeList() {
        fantasyEpisodeAdapter = FantasyEpisodeAdapter { showDetails(it) }
        fantasyEpisodeAdapter.notifyDataSetChanged()
        fantasyEpisodeAdapter.setData(getlistEpisode())
        rv_episode_fantasy.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_episode_fantasy.adapter = fantasyEpisodeAdapter
        rv_episode_fantasy.setHasFixedSize(true)
    }

    private fun showDetails(it: FantasyModel) {
        val intent = Intent(this, FantasyEpisodeActivity::class.java)
        intent.putExtra(FantasyEpisodeActivity.KEY_FANTASY_EPISODE, it)
        startActivity(intent)
    }

    private fun getlistEpisode(): ArrayList<FantasyModel> {
        val fantasyCover = resources.obtainTypedArray(R.array.fantasy_cover)
        val fantasyTitle = resources.getStringArray(R.array.fantasy_title)
        val fantasyGenre = resources.getStringArray(R.array.fantasy_genre)
        val fantasySynopsis = resources.getStringArray(R.array.fantasy_synopsis)
        val fantasyAuthor = resources.getStringArray(R.array.fantasy_author)
        val fantasyEpisodeTitle = resources.getStringArray(R.array.fantasy_episode_title)
        val fantasyReleaseDate = resources.getStringArray(R.array.fantasy_release_date)
        val fantasyHeadline = resources.getStringArray(R.array.fantasy_headline)
        val fantasyContent = resources.getStringArray(R.array.fantasy_content)

        val listEpisode = ArrayList<FantasyModel>()

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
            listEpisode.add(novel)
        }
        return listEpisode
    }
}
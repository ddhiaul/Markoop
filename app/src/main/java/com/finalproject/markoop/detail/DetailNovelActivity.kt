package com.finalproject.markoop.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.episode.activity.EpisodeActivity
import com.finalproject.markoop.episode.adapter.EpisodeAdapter
import com.finalproject.markoop.R
import com.finalproject.markoop.model.GenreModel
import kotlinx.android.synthetic.main.activity_detail_novel.*

class DetailNovelActivity : AppCompatActivity() {
    private val listEpisode = ArrayList<GenreModel>()
    private lateinit var episodeAdapater : EpisodeAdapter

    companion object{
        const val  KEY_ALL_GENRE = "key_all_genre"
    }

    private var model : GenreModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_novel)

        model = intent.getParcelableExtra(KEY_ALL_GENRE)

        img_detail_novel.setImageResource(model?.novelCover!!)
        tv_detail_novel_title.setText(model?.novelTitle)
        tv_detail_author.setText(model?.novelAuthor)
        tv_detail_genre.setText(model?.novelGenre)

        rv_episode.setHasFixedSize(true)
        listEpisode.addAll(getlistEpisode())

        showEpisodeList()
    }

    private fun showEpisodeList() {
        episodeAdapater = EpisodeAdapter { showDetails(it) }
        episodeAdapater.notifyDataSetChanged()
        episodeAdapater.setData(getlistEpisode())
        rv_episode.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_episode.adapter = episodeAdapater
        rv_episode.setHasFixedSize(true)
    }

    private fun showDetails(it: GenreModel) {
        val intent = Intent(this, EpisodeActivity::class.java)
        intent.putExtra(EpisodeActivity.KEY_ALL_EPISODE, it)
        startActivity(intent)
    }

    private fun getlistEpisode(): ArrayList<GenreModel> {
        val novelCover = resources.obtainTypedArray(R.array.novel_cover)
        val novelTitle = resources.getStringArray(R.array.novel_title)
        val novelGenre = resources.getStringArray(R.array.novel_genre)
        val novelSynopsis = resources.getStringArray(R.array.novel_synopsis)
        val novelAuthor = resources.getStringArray(R.array.novel_author)
        val episodeTitle = resources.getStringArray(R.array.episode_title)
        val releaseDate = resources.getStringArray(R.array.release_date)
        val headline = resources.getStringArray(R.array.headline)
        val content = resources.getStringArray(R.array.content)

        val listEpisode = ArrayList<GenreModel>()

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
            listEpisode.add(novel)
        }
        return listEpisode
    }


}
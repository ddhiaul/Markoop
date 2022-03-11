package com.finalproject.markoop.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.R
import com.finalproject.markoop.episode.activity.MysteryEpisodeActivity
import com.finalproject.markoop.episode.adapter.MysteryEpisodeAdapter
import com.finalproject.markoop.model.GenreModel
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.activity_detail_horror.*
import kotlinx.android.synthetic.main.activity_detail_mystery.*
import kotlinx.android.synthetic.main.activity_detail_novel.*
import kotlinx.android.synthetic.main.activity_detail_novel.img_detail_novel

class DetailMysteryActivity : AppCompatActivity() {

    private val listMysteryEpisode = ArrayList<MysteryModel>()
    private lateinit var mysteryEpisodeAdapter: MysteryEpisodeAdapter

    companion object{
        const val  KEY_ALL_MYSTERY = "key_all_mystery"
    }

    private var model : MysteryModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mystery)

        model = intent.getParcelableExtra(KEY_ALL_MYSTERY)

        img_detail_mystery.setImageResource(model?.mysteryCover!!)
        tv_detail_mystery_title.setText(model?.mysteryTitle)
        tv_detail_mystery_author.setText(model?.mysteryAuthor)
        tv_detail_mystery_genre.setText(model?.mysteryGenre)

        rv_episode_mystery.setHasFixedSize(true)
        listMysteryEpisode.addAll(getlistEpisode())

        showEpisodeList()

    }

    private fun showEpisodeList() {
        mysteryEpisodeAdapter = MysteryEpisodeAdapter { showDetails(it) }
        mysteryEpisodeAdapter.notifyDataSetChanged()
        mysteryEpisodeAdapter.setData(getlistEpisode())
        rv_episode_mystery.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_episode_mystery.adapter = mysteryEpisodeAdapter
        rv_episode_mystery.setHasFixedSize(true)
    }

    private fun showDetails(it: MysteryModel) {
        val intent = Intent(this, MysteryEpisodeActivity::class.java)
        intent.putExtra(MysteryEpisodeActivity.KEY_MYSTERY_EPISODE, it)
        startActivity(intent)
    }

    private fun getlistEpisode(): ArrayList<MysteryModel> {
        val mysteryCover = resources.obtainTypedArray(R.array.mystery_cover)
        val mysteryTitle = resources.getStringArray(R.array.mystery_title)
        val mysteryGenre = resources.getStringArray(R.array.mystery_genre)
        val mysterySynopsis = resources.getStringArray(R.array.mystery_synopsis)
        val mysteryAuthor = resources.getStringArray(R.array.mystery_author)
        val mysteryEpisodeTitle = resources.getStringArray(R.array.mystery_episode_title)
        val mysteryReleaseDate = resources.getStringArray(R.array.mystery_release_date)
        val mysteryHeadline = resources.getStringArray(R.array.mystery_headline)
        val mysteryContent = resources.getStringArray(R.array.mystery_content)

        val listEpisode = ArrayList<MysteryModel>()

        for (position in mysteryTitle.indices){
            val novel = MysteryModel(
                mysteryCover.getResourceId(position, -1),
                mysteryTitle[position],
                mysteryGenre[position],
                mysterySynopsis[position],
                mysteryAuthor[position],
                mysteryEpisodeTitle[position],
                mysteryReleaseDate[position],
                mysteryHeadline[position],
                mysteryContent[position]
            )
            listEpisode.add(novel)
        }
        return listEpisode
    }
}
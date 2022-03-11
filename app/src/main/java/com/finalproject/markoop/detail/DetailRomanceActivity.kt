package com.finalproject.markoop.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.R
import com.finalproject.markoop.episode.activity.EpisodeActivity
import com.finalproject.markoop.episode.activity.MysteryEpisodeActivity
import com.finalproject.markoop.episode.activity.RomanceEpisodeActivity
import com.finalproject.markoop.episode.adapter.RomanceEpisodeAdapter
import com.finalproject.markoop.model.RomanceModel
import kotlinx.android.synthetic.main.activity_detail_novel.*
import kotlinx.android.synthetic.main.activity_detail_romance.*

class DetailRomanceActivity : AppCompatActivity() {

    private val listRomanceEpisode = ArrayList<RomanceModel>()
    private lateinit var romanceEpisodeAdapter: RomanceEpisodeAdapter

    companion object{
        const val  KEY_ALL_ROMANCE = "key_all_romance"
    }

    private var model : RomanceModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_romance)

        model = intent.getParcelableExtra(KEY_ALL_ROMANCE)

        img_detail_romance.setImageResource(model?.romanceCover!!)
        tv_detail_romance_title.setText(model?.romanceTitle)
        tv_detail_romance_author.setText(model?.romanceAuthor)
        tv_detail_romance_genre.setText(model?.romanceGenre)

        rv_episode_romance.setHasFixedSize(true)
        listRomanceEpisode.addAll(getlistEpisode())

        showEpisodeList()

    }

    private fun showEpisodeList() {
        romanceEpisodeAdapter = RomanceEpisodeAdapter { showDetails(it) }
        romanceEpisodeAdapter.notifyDataSetChanged()
        romanceEpisodeAdapter.setData(getlistEpisode())
        rv_episode_romance.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_episode_romance.adapter = romanceEpisodeAdapter
        rv_episode_romance.setHasFixedSize(true)
    }

    private fun showDetails(it: RomanceModel) {
        val intent = Intent(this, RomanceEpisodeActivity::class.java)
        intent.putExtra(RomanceEpisodeActivity.KEY_ROMANCE_EPISODE, it)
        startActivity(intent)
    }

    private fun getlistEpisode(): ArrayList<RomanceModel> {
        val romanceCover = resources.obtainTypedArray(R.array.romance_cover)
        val romanceTitle = resources.getStringArray(R.array.romance_title)
        val romanceGenre = resources.getStringArray(R.array.romance_genre)
        val romanceSynopsis = resources.getStringArray(R.array.romance_synopsis)
        val romanceAuthor = resources.getStringArray(R.array.romance_author)
        val romanceEpisodeTitle = resources.getStringArray(R.array.romance_episode_title)
        val romanceReleaseDate = resources.getStringArray(R.array.romance_release_date)
        val romanceHeadline = resources.getStringArray(R.array.romance_headline)
        val romanceContent = resources.getStringArray(R.array.romance_content)

        val listEpisode = ArrayList<RomanceModel>()

        for (position in romanceTitle.indices){
            val novel = RomanceModel(
                romanceCover.getResourceId(position, -1),
                romanceTitle[position],
                romanceGenre[position],
                romanceSynopsis[position],
                romanceAuthor[position],
                romanceEpisodeTitle[position],
                romanceReleaseDate[position],
                romanceHeadline[position],
                romanceContent[position]
            )
            listEpisode.add(novel)
        }
        return listEpisode
    }

}
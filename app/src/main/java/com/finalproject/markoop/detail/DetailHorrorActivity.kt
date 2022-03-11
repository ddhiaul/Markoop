package com.finalproject.markoop.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.R
import com.finalproject.markoop.episode.activity.HorrorEpisodeActivity
import com.finalproject.markoop.episode.adapter.HorrorEpisodeAdapter
import com.finalproject.markoop.model.HorrorModel
import kotlinx.android.synthetic.main.activity_detail_horror.*
import kotlinx.android.synthetic.main.activity_detail_novel.*

class DetailHorrorActivity : AppCompatActivity() {

    private val listHorrorEpisode = ArrayList<HorrorModel>()
    private lateinit var horrorEpisodeAdapter: HorrorEpisodeAdapter

    companion object{
        const val  KEY_ALL_HORROR = "key_all_horror"
    }

    private var model : HorrorModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_horror)

        model = intent.getParcelableExtra(KEY_ALL_HORROR)

        img_detail_horror.setImageResource(model?.horrorCover!!)
        tv_detail_horror_title.setText(model?.horrorTitle)
        tv_detail_horror_author.setText(model?.horrorAuthor)
        tv_detail_horror_genre.setText(model?.horrorGenre)

        rv_episode_horror.setHasFixedSize(true)
        listHorrorEpisode.addAll(getlistEpisode())

        showEpisodeList()
    }

    private fun showEpisodeList() {
        horrorEpisodeAdapter = HorrorEpisodeAdapter { showDetails(it) }
        horrorEpisodeAdapter.notifyDataSetChanged()
        horrorEpisodeAdapter.setData(getlistEpisode())
        rv_episode_horror.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_episode_horror.adapter = horrorEpisodeAdapter
        rv_episode_horror.setHasFixedSize(true)
    }

    private fun showDetails(it: HorrorModel) {
        val intent = Intent(this, HorrorEpisodeActivity::class.java)
        intent.putExtra(HorrorEpisodeActivity.KEY_HORROR_EPISODE, it)
        startActivity(intent)
    }

    private fun getlistEpisode(): ArrayList<HorrorModel> {
        val horrorCover = resources.obtainTypedArray(R.array.horror_cover)
        val horrorTitle = resources.getStringArray(R.array.horror_title)
        val horrorGenre = resources.getStringArray(R.array.horror_genre)
        val horrorSynopsis = resources.getStringArray(R.array.horror_synopsis)
        val horrorAuthor = resources.getStringArray(R.array.horror_author)
        val horrorEpisodeTitle = resources.getStringArray(R.array.horror_episode_title)
        val horrorReleaseDate = resources.getStringArray(R.array.horror_release_date)
        val horrorHeadline = resources.getStringArray(R.array.horror_headline)
        val horrorContent = resources.getStringArray(R.array.horror_content)

        val listEpisode = ArrayList<HorrorModel>()

        for (position in horrorTitle.indices){
            val novel = HorrorModel(
                horrorCover.getResourceId(position, -1),
                horrorTitle[position],
                horrorGenre[position],
                horrorSynopsis[position],
                horrorAuthor[position],
                horrorEpisodeTitle[position],
                horrorReleaseDate[position],
                horrorHeadline[position],
                horrorContent[position]
            )
            listEpisode.add(novel)
        }
        return listEpisode
    }
}
package com.finalproject.markoop.episode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.R
import com.finalproject.markoop.model.RomanceModel
import kotlinx.android.synthetic.main.activity_episode.*
import kotlinx.android.synthetic.main.activity_romance_episode.*

class RomanceEpisodeActivity : AppCompatActivity() {

    companion object{
        const val  KEY_ROMANCE_EPISODE = "key_romance_episode"
    }

    private var model : RomanceModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_romance_episode)

        model = intent.getParcelableExtra(KEY_ROMANCE_EPISODE)

        tv_episode_romance.setText(model?.romanceEpisodeTitle)
        tv_romance_title_episode.setText(model?.romanceTitle)
        tv_romance_author_episode.setText("by ${model?.romanceAuthor}")
        tv_headlines_romance.setText(model?.romanceHeadline)
        tv_release_date_romance.setText(model?.romanceReleaseDate)
        tv_content_romance.setText(model?.romanceContent)

    }
}
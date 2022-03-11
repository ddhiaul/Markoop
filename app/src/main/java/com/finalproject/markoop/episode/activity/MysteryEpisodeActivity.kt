package com.finalproject.markoop.episode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.R
import com.finalproject.markoop.model.GenreModel
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.activity_episode.*
import kotlinx.android.synthetic.main.activity_episode.tv_episode
import kotlinx.android.synthetic.main.activity_mystery_episode.*

class MysteryEpisodeActivity : AppCompatActivity() {

    companion object{
        const val  KEY_MYSTERY_EPISODE = "key_mystery_episode"
    }

    private var model : MysteryModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystery_episode)

        model = intent.getParcelableExtra(KEY_MYSTERY_EPISODE)

        tv_episode_mystery.setText(model?.mysteryEpisodeTitle)
        tv_mystery_title_episode.setText(model?.mysteryTitle)
        tv_mystery_author_episode.setText("by ${model?.mysteryAuthor}")
        tv_headlines_mystery.setText(model?.mysteryHeadline)
        tv_release_date_mystery.setText(model?.mysteryReleaseDate)
        tv_content_mystery.setText(model?.mysteryContent)
    }


}
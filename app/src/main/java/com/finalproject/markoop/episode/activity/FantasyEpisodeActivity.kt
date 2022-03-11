package com.finalproject.markoop.episode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.R
import com.finalproject.markoop.model.FantasyModel
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.activity_episode.*
import kotlinx.android.synthetic.main.activity_fantasy_episode.*

class FantasyEpisodeActivity : AppCompatActivity() {

    companion object{
        const val  KEY_FANTASY_EPISODE = "key_fantasy_episode"
    }

    private var model : FantasyModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fantasy_episode)

        model = intent.getParcelableExtra(KEY_FANTASY_EPISODE)

        tv_episode_fantasy.setText(model?.fantasyEpisodeTitle)
        tv_fantasy_title_episode.setText(model?.fantasyTitle)
        tv_fantasy_author_episode.setText("by ${model?.fantasyAuthor}")
        tv_headlines_fantasy.setText(model?.fantasyHeadline)
        tv_release_date_fantasy.setText(model?.fantasyReleaseDate)
        tv_content_fantasy.setText(model?.fantasyContent)

    }
}
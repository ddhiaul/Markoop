package com.finalproject.markoop.episode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.R
import com.finalproject.markoop.model.GenreModel
import com.finalproject.markoop.model.HorrorModel
import kotlinx.android.synthetic.main.activity_episode.*

class HorrorEpisodeActivity : AppCompatActivity() {

    companion object{
        const val  KEY_HORROR_EPISODE = "key_horror_episode"
    }

    private var model : HorrorModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horror_episode)

        model = intent.getParcelableExtra(KEY_HORROR_EPISODE)

        tv_episode.setText(model?.horrorEpisodeTitle)
        tv_novel_title_episode.setText(model?.horrorTitle)
        tv_author_episode.setText("by ${model?.horrorAuthor}")
        tv_headlines.setText(model?.horrorHeadline)
        tv_release_date.setText(model?.horrorReleaseDate)
        tv_content.setText(model?.horrorContent)

    }
}
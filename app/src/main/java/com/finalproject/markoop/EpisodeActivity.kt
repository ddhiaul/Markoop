package com.finalproject.markoop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.model.GenreModel
import kotlinx.android.synthetic.main.activity_episode.*

class EpisodeActivity : AppCompatActivity() {

    companion object{
        const val  KEY_ALL_EPISODE = "key_all_episode"
    }

    private var model : GenreModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)

        model = intent.getParcelableExtra(KEY_ALL_EPISODE)

        tv_episode.setText(model?.episodeTitle)
        tv_novel_title_episode.setText(model?.novelTitle)
        tv_author_episode.setText("by ${model?.novelAuthor}")
        tv_headlines.setText(model?.headline)
        tv_release_date.setText(model?.releaseDate)
        tv_content.setText(model?.content)


    }
}
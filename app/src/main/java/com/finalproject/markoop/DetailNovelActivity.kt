package com.finalproject.markoop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.R
import com.finalproject.markoop.genre.GenreModel
import kotlinx.android.synthetic.main.activity_detail_novel.*

class DetailNovelActivity : AppCompatActivity() {
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
    }


}
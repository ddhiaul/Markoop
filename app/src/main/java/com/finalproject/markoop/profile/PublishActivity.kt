package com.finalproject.markoop.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.R
import com.finalproject.markoop.profile.publish.CreateEpisodeActivity
import com.finalproject.markoop.profile.publish.CreateNovelActivity
import kotlinx.android.synthetic.main.activity_publish.*

class PublishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish)

        btn_create_novel.setOnClickListener { startActivity(Intent(this, CreateNovelActivity::class.java)) }
        btn_add_episode.setOnClickListener { startActivity(Intent(this, CreateEpisodeActivity::class.java)) }
    }
}
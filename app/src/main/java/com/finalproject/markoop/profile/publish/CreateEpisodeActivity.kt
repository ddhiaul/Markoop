package com.finalproject.markoop.profile.publish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.finalproject.markoop.R
import kotlinx.android.synthetic.main.activity_create_episode.*
import kotlinx.android.synthetic.main.activity_create_novel.*

class CreateEpisodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_episode)

        btn_save_episode.setOnClickListener {
            Toast.makeText(this, "Episode Created", Toast.LENGTH_SHORT).show()
        }
    }
}
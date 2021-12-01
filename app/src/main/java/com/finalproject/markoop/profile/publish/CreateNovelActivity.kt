package com.finalproject.markoop.profile.publish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.R
import com.finalproject.markoop.profile.PublishActivity
import kotlinx.android.synthetic.main.activity_create_novel.*

class CreateNovelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_novel)

        btn_create_to_publish.setOnClickListener {
            startActivity(Intent(this, PublishActivity::class.java)) }
    }
}
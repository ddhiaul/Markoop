package com.finalproject.markoop.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finalproject.markoop.R
import kotlinx.android.synthetic.main.activity_my_fav_novel.*

class MyFavNovelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_fav_novel)

        btn_back_to_setting.setOnClickListener {
//            startActivity(Intent(this, ProfileFragment::class.java))
        }

    }
}
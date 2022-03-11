package com.finalproject.markoop.profile.publish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.finalproject.markoop.R
import com.finalproject.markoop.profile.PublishActivity
import kotlinx.android.synthetic.main.activity_create_novel.*

class CreateNovelActivity : AppCompatActivity() {
    val REQUEST_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_novel)

        btn_back_create_novel.setOnClickListener {
            startActivity(Intent(this, PublishActivity::class.java)) }

        img_add_cover.setOnClickListener {
            openGalleryForImage()
        }

        btn_save_novel.setOnClickListener {
            Toast.makeText(this, "Novel Created", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }
}
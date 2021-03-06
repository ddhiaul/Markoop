package com.finalproject.markoop

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.finalproject.markoop.profile.MyFavNovelActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import android.content.Context.MODE_PRIVATE
import com.finalproject.markoop.landingPage.SplashScreen
import com.finalproject.markoop.profile.AboutUsActivity
import com.finalproject.markoop.profile.MyNovelActivity

import com.finalproject.markoop.profile.PublishActivity


class ProfileFragment : Fragment() {

    val REQUEST_CODE = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPrefs: SharedPreferences = requireActivity().getSharedPreferences("DarkMode", MODE_PRIVATE)
        btn_theme.setChecked(sharedPrefs.getBoolean("DarkMode", true))

        btn_theme.setOnCheckedChangeListener { button, b ->
            if (btn_theme.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                val editor: SharedPreferences.Editor = requireActivity().getSharedPreferences("DarkMode", MODE_PRIVATE).edit()
                editor.putBoolean("DarkMode", true)
                editor.commit()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                val editor: SharedPreferences.Editor = requireActivity().getSharedPreferences("DarkMode", MODE_PRIVATE).edit()
                editor.putBoolean("DarkMode", false)
                editor.commit()
            }
        }

        btn_fav_novel.setOnClickListener { startActivity(Intent(context, MyFavNovelActivity::class.java)) }
        btn_publish.setOnClickListener { startActivity(Intent(context, PublishActivity::class.java)) }
        btn_my_novel.setOnClickListener { startActivity(Intent(context, MyNovelActivity::class.java)) }
        btn_about_us.setOnClickListener { startActivity(Intent(context, AboutUsActivity::class.java)) }
        btn_logout.setOnClickListener { startActivity(Intent(context, SplashScreen::class.java)) }

        img_profile.setOnClickListener {
            openGalleryForImage()
        }

    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }



}
package com.finalproject.markoop

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat.recreate
import com.finalproject.markoop.R
import kotlinx.android.synthetic.main.fragment_profile.*

const val FIRST_START = "FirstStart"
const val NIGHT_MODE = "NightMode"
const val PREF = "AppSettingsPrefs"

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appSettingsPrefs: SharedPreferences? = this.getActivity()?.getSharedPreferences("PREF", Context.MODE_PRIVATE)
        val isNightModeOn: Boolean = appSettingsPrefs!!.getBoolean(NIGHT_MODE, true)
        val isFirstStart: Boolean = appSettingsPrefs.getBoolean(FIRST_START,false)
        val editor: SharedPreferences.Editor = appSettingsPrefs.edit()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && isFirstStart ){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        } else{
            when {
                isNightModeOn -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            }
        }
        
        btn_theme.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean(FIRST_START, false)
                editor.putBoolean(NIGHT_MODE, true)
                editor.apply()
                //recreate activity to make changes visible
//                recreate(requireActivity())
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean(FIRST_START, false)
                editor.putBoolean(NIGHT_MODE, false)
                editor.apply()
//                recreate(requireActivity())
            }
        }

//        btn_theme.setOnClickListener {
//            if (isNightModeOn) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                editor.putBoolean(FIRST_START, false)
//                editor.putBoolean(NIGHT_MODE, false)
//                editor.apply()
//                //recreate activity to make changes visible
//                recreate(requireActivity())
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                editor.putBoolean(FIRST_START, false)
//                editor.putBoolean(NIGHT_MODE, true)
//                editor.apply()
//                recreate(requireActivity())
//
//            }
//        }
    }

//    override fun onStart() {
//        super.onStart()
//        Log.i(TAG, "onStart")
//    }
//
//    override fun onResume(){
//        super.onResume()
//        Log.i(TAG, "onResume")
//    }
//
//    override fun onPause() {
//        Log.i(TAG, "onPause")
//        super.onPause()
//    }
//
//    override fun onStop() {
//        Log.i(TAG, "onStop")
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        Log.i(TAG, "onDestroy")
//        super.onDestroy()
//    }
//
//    companion object {
//        private const val TAG = "ProfileFragment"
//    }

}
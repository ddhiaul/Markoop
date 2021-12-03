package com.finalproject.markoop.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.finalproject.markoop.detail.DetailNovelActivity
import com.finalproject.markoop.ImageSliderAdapter
import com.finalproject.markoop.R
import com.finalproject.markoop.model.GenreModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList

class HomeFragment : Fragment() {
    private val model = ArrayList<GenreModel>()
    private lateinit var homeAdapater : HomeAdapter

    companion object {
        fun defaultFragment() : HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    // creating object of ViewPager
    var mViewPager: ViewPager? = null

    // images array
    var images = intArrayOf(
        R.drawable.banner, R.drawable.banner, R.drawable.banner, R.drawable.banner,
        R.drawable.banner
    )

    // Creating Object of ViewPagerAdapter
    var mImageSliderAdapter: ImageSliderAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initializing the ViewPager Object
        mViewPager = viewPager_home as ViewPager

        // Initializing the ViewPagerAdapter
        mImageSliderAdapter = ImageSliderAdapter(requireContext(), images)

        // Adding the Adapter to the ViewPager
        mViewPager!!.adapter = mImageSliderAdapter

        model.addAll(getListNovel())
        rv_recomendation.setHasFixedSize(true)
        rv_best_fantasy.setHasFixedSize(true)

        showRecomendedList()
        showBestFantasyList()

    }

    private fun showRecomendedList() {
        homeAdapater = HomeAdapter { showDetails(it) }
        homeAdapater.notifyDataSetChanged()
        homeAdapater.setData(getListNovel())
        rv_recomendation.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_recomendation.adapter = homeAdapater
        rv_recomendation.setHasFixedSize(true)
    }

    private fun showDetails(it: GenreModel) {
        val intent = Intent(context, DetailNovelActivity::class.java)
        intent.putExtra(DetailNovelActivity.KEY_ALL_GENRE, it)
        startActivity(intent)
    }

    private fun showBestFantasyList() {
        homeAdapater = HomeAdapter { showDetails(it) }
        homeAdapater.notifyDataSetChanged()
        homeAdapater.setData(getListNovel())
        rv_best_fantasy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_best_fantasy.adapter = homeAdapater
        rv_best_fantasy.setHasFixedSize(true)
    }

    private fun getListNovel(): ArrayList<GenreModel> {
        val novelCover = resources.obtainTypedArray(R.array.novel_cover)
        val novelTitle = resources.getStringArray(R.array.novel_title)
        val novelGenre = resources.getStringArray(R.array.novel_genre)
        val novelSynopsis = resources.getStringArray(R.array.novel_synopsis)
        val novelAuthor = resources.getStringArray(R.array.novel_author)
        val episodeTitle = resources.getStringArray(R.array.episode_title)
        val releaseDate = resources.getStringArray(R.array.release_date)
        val headline = resources.getStringArray(R.array.headline)
        val content = resources.getStringArray(R.array.content)

        val model = ArrayList<GenreModel>()

        for (position in novelTitle.indices){
            val novel = GenreModel(
                novelCover.getResourceId(position, -1),
                novelTitle[position],
                novelGenre[position],
                novelSynopsis[position],
                novelAuthor[position],
                episodeTitle[position],
                releaseDate[position],
                headline[position],
                content[position]
            )
            model.add(novel)
        }
        return model
    }
}
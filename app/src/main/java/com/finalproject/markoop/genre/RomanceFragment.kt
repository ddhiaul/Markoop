package com.finalproject.markoop.genre

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.R
import com.finalproject.markoop.adapter.MysteryAdapter
import com.finalproject.markoop.adapter.RomanceAdapter
import com.finalproject.markoop.detail.DetailMysteryActivity
import com.finalproject.markoop.detail.DetailRomanceActivity
import com.finalproject.markoop.model.MysteryModel
import com.finalproject.markoop.model.RomanceModel
import kotlinx.android.synthetic.main.fragment_fantasy.*
import kotlinx.android.synthetic.main.fragment_mystery.*
import kotlinx.android.synthetic.main.fragment_romance.*

class RomanceFragment : Fragment() {

    private val listRomance = ArrayList<RomanceModel>()
    private lateinit var romanceAdapter: RomanceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_romance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_romance.setHasFixedSize(true)
        listRomance.addAll(getListGenre())

        showGenreList()
    }

    private fun showGenreList() {
        romanceAdapter = RomanceAdapter { showDetails(it) }
        romanceAdapter.notifyDataSetChanged()
        romanceAdapter.setData(getListGenre())
        rv_romance.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_romance.adapter = romanceAdapter
        rv_romance.setHasFixedSize(true)
    }

    private fun showDetails(it: RomanceModel) {
        val intent = Intent(context, DetailRomanceActivity::class.java)
        intent.putExtra(DetailRomanceActivity.KEY_ALL_ROMANCE, it)
        startActivity(intent)
    }

    private fun getListGenre(): ArrayList<RomanceModel> {
        val romanceCover = resources.obtainTypedArray(R.array.romance_cover)
        val romanceTitle = resources.getStringArray(R.array.romance_title)
        val romanceGenre = resources.getStringArray(R.array.romance_genre)
        val romanceSynopsis = resources.getStringArray(R.array.romance_synopsis)
        val romanceAuthor = resources.getStringArray(R.array.romance_author)
        val romanceEpisodeTitle = resources.getStringArray(R.array.romance_episode_title)
        val romanceReleaseDate = resources.getStringArray(R.array.romance_release_date)
        val romanceHeadline = resources.getStringArray(R.array.romance_headline)
        val romanceContent = resources.getStringArray(R.array.romance_content)

        val listGenre = ArrayList<RomanceModel>()

        for (position in romanceTitle.indices){
            val novel = RomanceModel(
                romanceCover.getResourceId(position, -1),
                romanceTitle[position],
                romanceGenre[position],
                romanceSynopsis[position],
                romanceAuthor[position],
                romanceEpisodeTitle[position],
                romanceReleaseDate[position],
                romanceHeadline[position],
                romanceContent[position]
            )
            listGenre.add(novel)
        }
        return listGenre
    }

}
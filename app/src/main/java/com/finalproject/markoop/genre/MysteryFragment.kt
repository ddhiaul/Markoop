package com.finalproject.markoop.genre

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.DetailNovelActivity
import com.finalproject.markoop.R
import com.finalproject.markoop.adapter.HorrorAdapter
import com.finalproject.markoop.adapter.MysteryAdapter
import com.finalproject.markoop.model.HorrorModel
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.fragment_horror.*
import kotlinx.android.synthetic.main.fragment_mystery.*

class MysteryFragment : Fragment() {

    private val listMystery = ArrayList<MysteryModel>()
    private lateinit var mysteryAdapter: MysteryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mystery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_mystery.setHasFixedSize(true)
        listMystery.addAll(getListGenre())

        showGenreList()
    }

    private fun showGenreList() {
        mysteryAdapter = MysteryAdapter { showDetails(it) }
        mysteryAdapter.notifyDataSetChanged()
        mysteryAdapter.setData(getListGenre())
        rv_mystery.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_mystery.adapter = mysteryAdapter
        rv_mystery.setHasFixedSize(true)
    }

    private fun showDetails(it: MysteryModel) {
        val intent = Intent(context, DetailNovelActivity::class.java)
        intent.putExtra(DetailNovelActivity.KEY_ALL_GENRE, it)
        startActivity(intent)
    }

    private fun getListGenre(): ArrayList<MysteryModel> {
        val mysteryCover = resources.obtainTypedArray(R.array.mystery_cover)
        val mysteryTitle = resources.getStringArray(R.array.mystery_title)
        val mysteryGenre = resources.getStringArray(R.array.mystery_genre)
        val mysterySynopsis = resources.getStringArray(R.array.mystery_synopsis)
        val mysteryAuthor = resources.getStringArray(R.array.mystery_author)
        val mysteryEpisodeTitle = resources.getStringArray(R.array.mystery_episode_title)
        val mysteryReleaseDate = resources.getStringArray(R.array.mystery_release_date)
        val mysteryHeadline = resources.getStringArray(R.array.mystery_headline)
        val mysteryContent = resources.getStringArray(R.array.mystery_content)

        val listGenre = ArrayList<MysteryModel>()

        for (position in mysteryTitle.indices){
            val novel = MysteryModel(
                mysteryCover.getResourceId(position, -1),
                mysteryTitle[position],
                mysteryGenre[position],
                mysterySynopsis[position],
                mysteryAuthor[position],
                mysteryEpisodeTitle[position],
                mysteryReleaseDate[position],
                mysteryHeadline[position],
                mysteryContent[position]
            )
            listGenre.add(novel)
        }
        return listGenre
    }

}
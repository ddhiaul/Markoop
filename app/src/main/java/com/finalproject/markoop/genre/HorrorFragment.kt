package com.finalproject.markoop.genre

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.finalproject.markoop.detail.DetailNovelActivity
import com.finalproject.markoop.R
import com.finalproject.markoop.adapter.HorrorAdapter
import com.finalproject.markoop.detail.DetailHorrorActivity
import com.finalproject.markoop.model.HorrorModel
import kotlinx.android.synthetic.main.fragment_horror.*

class HorrorFragment : Fragment() {
    private val listHorror = ArrayList<HorrorModel>()
    private lateinit var horrorAdapter: HorrorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horror, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_horror.setHasFixedSize(true)
        listHorror.addAll(getListGenre())

        showGenreList()
    }

    private fun showGenreList() {
        horrorAdapter = HorrorAdapter { showDetails(it) }
        horrorAdapter.notifyDataSetChanged()
        horrorAdapter.setData(getListGenre())
        rv_horror.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_horror.adapter = horrorAdapter
        rv_horror.setHasFixedSize(true)
    }

    private fun showDetails(it: HorrorModel) {
        val intent = Intent(context, DetailHorrorActivity::class.java)
        intent.putExtra(DetailHorrorActivity.KEY_ALL_HORROR, it)
        startActivity(intent)
    }

    private fun getListGenre(): ArrayList<HorrorModel> {
        val horrorCover = resources.obtainTypedArray(R.array.horror_cover)
        val horrorTitle = resources.getStringArray(R.array.horror_title)
        val horrorGenre = resources.getStringArray(R.array.horror_genre)
        val horrorSynopsis = resources.getStringArray(R.array.horror_synopsis)
        val horrorAuthor = resources.getStringArray(R.array.horror_author)
        val horrorEpisodeTitle = resources.getStringArray(R.array.horror_episode_title)
        val horrorReleaseDate = resources.getStringArray(R.array.horror_release_date)
        val horrorHeadline = resources.getStringArray(R.array.horror_headline)
        val horrorContent = resources.getStringArray(R.array.horror_content)

        val listGenre = ArrayList<HorrorModel>()

        for (position in horrorTitle.indices){
            val novel = HorrorModel(
                horrorCover.getResourceId(position, -1),
                horrorTitle[position],
                horrorGenre[position],
                horrorSynopsis[position],
                horrorAuthor[position],
                horrorEpisodeTitle[position],
                horrorReleaseDate[position],
                horrorHeadline[position],
                horrorContent[position]
            )
            listGenre.add(novel)
        }
        return listGenre
    }
}
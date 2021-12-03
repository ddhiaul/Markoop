package com.finalproject.markoop.episode.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.markoop.R
import com.finalproject.markoop.model.FantasyModel
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.item_episode.view.*

class FantasyEpisodeAdapter(private val listener: (FantasyModel) -> Unit) : RecyclerView.Adapter<FantasyEpisodeAdapter.ViewHolder>() {
    private val episode = ArrayList<FantasyModel>()

    fun setData(items: ArrayList<FantasyModel>) {
        episode.clear()
        episode.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: FantasyModel, listener: (FantasyModel) -> Unit) {
            with(itemView) {
                tv_episodelist_title.setText(model.fantasyEpisodeTitle)
                tv_episodelist_releasedate.setText(model.fantasyReleaseDate)

                itemView.setOnClickListener { listener(model) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(episode[position], listener)
    }

    override fun getItemCount(): Int = episode.size
}
package com.finalproject.markoop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.markoop.model.GenreModel
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodeAdapter(private val listener: (GenreModel) -> Unit) : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {
    private val episode = ArrayList<GenreModel>()

    fun setData(items: ArrayList<GenreModel>) {
        episode.clear()
        episode.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: GenreModel, listener: (GenreModel) -> Unit) {
            with(itemView) {
                tv_episodelist_title.setText(model.episodeTitle)
                tv_episodelist_releasedate.setText(model.releaseDate)

                itemView.setOnClickListener { listener(model) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode, parent, false)
        return EpisodeAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(episode[position], listener)
    }

    override fun getItemCount(): Int = episode.size
}
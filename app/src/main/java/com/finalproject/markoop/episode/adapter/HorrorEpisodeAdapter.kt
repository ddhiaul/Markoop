package com.finalproject.markoop.episode.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.markoop.R
import com.finalproject.markoop.model.HorrorModel
import kotlinx.android.synthetic.main.item_episode.view.*

class HorrorEpisodeAdapter(private val listener: (HorrorModel) -> Unit) : RecyclerView.Adapter<HorrorEpisodeAdapter.ViewHolder>() {
    private val episode = ArrayList<HorrorModel>()

    fun setData(items: ArrayList<HorrorModel>) {
        episode.clear()
        episode.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: HorrorModel, listener: (HorrorModel) -> Unit) {
            with(itemView) {
                tv_episodelist_title.setText(model.horrorEpisodeTitle)
                tv_episodelist_releasedate.setText(model.horrorReleaseDate)

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
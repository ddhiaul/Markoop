package com.finalproject.markoop.episode.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.markoop.R
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.item_episode.view.*

class MysteryEpisodeAdapter(private val listener: (MysteryModel) -> Unit) : RecyclerView.Adapter<MysteryEpisodeAdapter.ViewHolder>() {
    private val episode = ArrayList<MysteryModel>()

    fun setData(items: ArrayList<MysteryModel>) {
        episode.clear()
        episode.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: MysteryModel, listener: (MysteryModel) -> Unit) {
            with(itemView) {
                tv_episodelist_title.setText(model.mysteryEpisodeTitle)
                tv_episodelist_releasedate.setText(model.mysteryReleaseDate)

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
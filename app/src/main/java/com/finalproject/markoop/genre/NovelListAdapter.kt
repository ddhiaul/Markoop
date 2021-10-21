package com.finalproject.markoop.genre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.markoop.R
import kotlinx.android.synthetic.main.item_genre.view.*

class NovelListAdapter (private val listGenre : ArrayList<GenreModel>) : RecyclerView.Adapter<NovelListAdapter.ViewHolder>() {
    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: GenreModel) {
            with(itemView) {
                tv_novel_title_genre.setText(model.novelTitle)
                tv_novel_genre_genre.setText(model.novelGenre)
                tv_synopsis_genre.setText(model.novelSynopsis)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genre, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listGenre[position])
    }

    override fun getItemCount(): Int = listGenre.size
}
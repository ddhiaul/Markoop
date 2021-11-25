package com.finalproject.markoop.genre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.markoop.R
import kotlinx.android.synthetic.main.item_genre.view.*

class NovelListAdapter(private val listener: (GenreModel) -> Unit) : RecyclerView.Adapter<NovelListAdapter.ViewHolder>() {
    private val listAllGenre = ArrayList<GenreModel>()

    fun setData(items: ArrayList<GenreModel>) {
        listAllGenre.clear()
        listAllGenre.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: GenreModel, listGenre: (GenreModel) -> Unit) {
            with(itemView) {
                tv_novel_title_genre.setText(model.novelTitle)
                tv_novel_genre_genre.setText(model.novelGenre)
                tv_synopsis_genre.setText(model.novelSynopsis)

                itemView.setOnClickListener { listGenre(model) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genre, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAllGenre[position], listener)
    }

    override fun getItemCount(): Int = listAllGenre.size
}
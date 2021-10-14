package com.finalproject.markoop.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.dean.markoop.R
import com.finalproject.markoop.genre.GenreModel
import kotlinx.android.synthetic.main.item_grid_home.view.*

class HomeAdapter(private val listHome: ArrayList<GenreModel>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: GenreModel) {
            with(itemView) {
                tv_title_grid.setText(model.novelTitle)
                tv_genre_grid.setText(model.novelGenre)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHome[position])
    }

    override fun getItemCount(): Int = listHome.size

}
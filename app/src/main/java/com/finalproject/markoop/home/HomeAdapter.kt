package com.finalproject.markoop.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finalproject.markoop.R
import com.finalproject.markoop.genre.GenreModel
import kotlinx.android.synthetic.main.item_grid_home.view.*

class HomeAdapter(private val listener: (GenreModel) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val modelHome = ArrayList<GenreModel>()

    fun setData(items: ArrayList<GenreModel>) {
        modelHome.clear()
        modelHome.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: GenreModel, modelHome: (GenreModel) -> Unit) {
            with(itemView) {
                img_novel_grid.setImageResource(model.novelCover)
                tv_title_grid.setText(model.novelTitle)
                tv_genre_grid.setText(model.novelGenre)

                itemView.setOnClickListener { modelHome(model) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(modelHome[position], listener)
    }

    override fun getItemCount(): Int = modelHome.size

}
package com.finalproject.markoop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.finalproject.markoop.R
import com.finalproject.markoop.model.GenreModel
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.item_genre.view.*

class MysteryAdapter(private val listener: (MysteryModel) -> Unit) : RecyclerView.Adapter<MysteryAdapter.ViewHolder>() {
    private val listAllMystery = ArrayList<MysteryModel>()

    fun setData(items: ArrayList<MysteryModel>) {
        listAllMystery.clear()
        listAllMystery.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: MysteryModel, listGenre: (MysteryModel) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(model.mysteryCover)
                    .apply(RequestOptions().override(800))
                    .into(img_novel_genre)
                tv_novel_title_genre.setText(model.mysteryTitle)
                tv_novel_genre_genre.setText(model.mysteryGenre)
                tv_synopsis_genre.setText(model.mysterySynopsis)

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
        holder.bind(listAllMystery[position], listener)
    }

    override fun getItemCount(): Int = listAllMystery.size
}
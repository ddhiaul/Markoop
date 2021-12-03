package com.finalproject.markoop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.finalproject.markoop.R
import com.finalproject.markoop.model.RomanceModel
import kotlinx.android.synthetic.main.item_genre.view.*

class RomanceAdapter(private val listener: (RomanceModel) -> Unit) : RecyclerView.Adapter<RomanceAdapter.ViewHolder>() {
    private val listAllRomance = ArrayList<RomanceModel>()

    fun setData(items: ArrayList<RomanceModel>) {
        listAllRomance.clear()
        listAllRomance.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: RomanceModel, listGenre: (RomanceModel) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(model.romanceCover)
                    .apply(RequestOptions().override(800))
                    .into(img_novel_genre)
                tv_novel_title_genre.setText(model.romanceTitle)
                tv_novel_genre_genre.setText(model.romanceGenre)
                tv_synopsis_genre.setText(model.romanceSynopsis)

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
        holder.bind(listAllRomance[position], listener)
    }

    override fun getItemCount(): Int = listAllRomance.size
}
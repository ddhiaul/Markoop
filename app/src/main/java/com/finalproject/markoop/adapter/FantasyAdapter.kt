package com.finalproject.markoop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.finalproject.markoop.R
import com.finalproject.markoop.model.FantasyModel
import kotlinx.android.synthetic.main.item_genre.view.*

class FantasyAdapter(private val listener: (FantasyModel) -> Unit) : RecyclerView.Adapter<FantasyAdapter.ViewHolder>() {
    private val listAllFantasy = ArrayList<FantasyModel>()

    fun setData(items: ArrayList<FantasyModel>) {
        listAllFantasy.clear()
        listAllFantasy.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: FantasyModel, listGenre: (FantasyModel) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(model.fantasyCover)
                    .apply(RequestOptions().override(800))
                    .into(img_novel_genre)
                tv_novel_title_genre.setText(model.fantasyTitle)
                tv_novel_genre_genre.setText(model.fantasyGenre)
                tv_synopsis_genre.setText(model.fantasySynopsis)

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
        holder.bind(listAllFantasy[position], listener)
    }

    override fun getItemCount(): Int = listAllFantasy.size
}
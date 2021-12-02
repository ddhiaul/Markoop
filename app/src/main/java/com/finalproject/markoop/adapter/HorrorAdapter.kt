package com.finalproject.markoop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.finalproject.markoop.R
import com.finalproject.markoop.model.GenreModel
import com.finalproject.markoop.model.HorrorModel
import com.finalproject.markoop.model.MysteryModel
import kotlinx.android.synthetic.main.item_genre.view.*

class HorrorAdapter(private val listener: (HorrorModel) -> Unit) : RecyclerView.Adapter<HorrorAdapter.ViewHolder>() {
    private val listAllHorror = ArrayList<HorrorModel>()

    fun setData(items: ArrayList<HorrorModel>) {
        listAllHorror.clear()
        listAllHorror.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemGenre: View) : RecyclerView.ViewHolder(itemGenre) {
        fun bind(model: HorrorModel, listGenre: (HorrorModel) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(model.horrorCover)
                    .apply(RequestOptions().override(800))
                    .into(img_novel_genre)
                tv_novel_title_genre.setText(model.horrorTitle)
                tv_novel_genre_genre.setText(model.horrorGenre)
                tv_synopsis_genre.setText(model.horrorSynopsis)

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
        holder.bind(listAllHorror[position], listener)
    }

    override fun getItemCount(): Int = listAllHorror.size
}
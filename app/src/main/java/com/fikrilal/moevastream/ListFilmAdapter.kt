package com.fikrilal.moevastream

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListFilmAdapter(private val listFilm: ArrayList<Film>) :
    RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPoster: ImageView = itemView.findViewById(R.id.img_film_poster)
        val tvName: TextView = itemView.findViewById(R.id.tv_film_name)
        val tvOverview: TextView = itemView.findViewById(R.id.tv_film_overview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_film, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFilm.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val film = listFilm[position]

        Glide.with(holder.itemView.context)
            .load(film.poster)
            .into(holder.imgPoster)

        holder.tvName.text = film.name
        holder.tvOverview.text = film.overview

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFilm[holder.adapterPosition]) }
    }


    interface OnItemClickCallback {
        fun onItemClicked(data: Film)
    }

}
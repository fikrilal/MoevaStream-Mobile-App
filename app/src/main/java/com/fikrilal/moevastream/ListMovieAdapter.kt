package com.fikrilal.moevastream

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMovieAdapter(private val listMovie: ArrayList<MovieList>) : RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movies, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, overview, poster) = listMovie[position]
        holder.imgPoster.setImageResource(poster)
        holder.tvTitle.text = title
        holder.tvOverview.text = overview
    }

    override fun getItemCount(): Int = listMovie.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPoster: ImageView = itemView.findViewById(R.id.img_movie_poster)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_movie_title)
        val tvOverview: TextView = itemView.findViewById(R.id.tv_movie_overview)
    }

}
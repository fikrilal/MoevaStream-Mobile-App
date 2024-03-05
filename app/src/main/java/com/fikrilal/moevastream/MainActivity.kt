package com.fikrilal.moevastream

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.parcelize.Parcelize

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<MovieList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movie_list)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    private fun getListMovies(): ArrayList<MovieList> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataOverview = resources.getStringArray(R.array.data_overview)
        val dataPoster = resources.obtainTypedArray(R.array.data_poster)
        val listMovie = ArrayList<MovieList>()
        for (i in dataName.indices) {
            val movie = MovieList(dataName[i], dataOverview[i], dataPoster.getResourceId(i, -1))
            listMovie.add(movie)
        }
        return  listMovie
    }

    private fun  showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listMovieAdapter
    }
}
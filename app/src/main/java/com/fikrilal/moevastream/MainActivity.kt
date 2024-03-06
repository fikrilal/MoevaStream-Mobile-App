package com.fikrilal.moevastream

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFilms: RecyclerView
    private val list = ArrayList<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.action_bar_logo)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        rvFilms = findViewById(R.id.rv_films)
        rvFilms.setHasFixedSize(true)

        list.addAll(getListFilm())
        showRecyclerList()
    }

    private fun getListFilm(): ArrayList<Film> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataOverview = resources.getStringArray(R.array.data_overview)
        val dataPoster = resources.obtainTypedArray(R.array.data_poster)
        val dataStoryline = resources.getStringArray(R.array.data_storyline)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataRuntime = resources.getStringArray(R.array.data_runtime)
        val dataRating = resources.getStringArray(R.array.data_rating)
        val dataTrailer = resources.getStringArray(R.array.data_trailer)
        val listFilm = ArrayList<Film>()
        for (i in dataName.indices) {
            val film = Film(
                dataName[i],
                dataOverview[i],
                dataPoster.getResourceId(i, -1),
                dataStoryline[i],
                dataGenre[i],
                dataRuntime[i],
                dataRating[i],
                dataTrailer[i]
            )
            listFilm.add(film)
        }
        return listFilm
    }

    private fun showRecyclerList() {
        rvFilms.layoutManager = LinearLayoutManager(this)
        val listFilmAdapter = ListFilmAdapter(list)
        rvFilms.adapter = listFilmAdapter

        listFilmAdapter.setOnItemClickCallback(object : ListFilmAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Film) {
                showSelectedFilm(data)
            }
        })
    }

    private fun showSelectedFilm(film: Film) {
        val intent = Intent(this, FilmDetailActivity::class.java).apply {
            putExtra("EXTRA_NAME", film.name)
            putExtra("EXTRA_OVERVIEW", film.overview)
            putExtra("EXTRA_POSTER", film.poster)
            putExtra("EXTRA_STORYLINE", film.storyline)
            putExtra("EXTRA_GENRE", film.genre)
            putExtra("EXTRA_RUNTIME", film.runtime)
            putExtra("EXTRA_RATING", film.rating)
            putExtra("EXTRA_TRAILER", film.trailer)
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
            else -> super.onOptionsItemSelected(item)
        }
        when (item.itemId) {
            R.id.action_list -> {
                rvFilms.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvFilms.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
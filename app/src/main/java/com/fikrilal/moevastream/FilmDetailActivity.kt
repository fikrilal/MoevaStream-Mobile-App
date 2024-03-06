package com.fikrilal.moevastream

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class FilmDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.action_bar_logo)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val name = intent.getStringExtra("EXTRA_NAME")
        val overview = intent.getStringExtra("EXTRA_OVERVIEW")
        val poster = intent.getIntExtra("EXTRA_POSTER", 0)
        val storyline = intent.getStringExtra("EXTRA_STORYLINE")
        val genre = intent.getStringExtra("EXTRA_GENRE")
        val runtime = intent.getStringExtra("EXTRA_RUNTIME")
        val rating = intent.getStringExtra("EXTRA_RATING")
        val trailer = intent.getStringExtra("EXTRA_TRAILER")

        findViewById<ImageView>(R.id.img_film_poster_detail).setImageResource(poster)
        findViewById<TextView>(R.id.tv_film_name_detail).text = name
        findViewById<TextView>(R.id.tv_film_overview_detail).text = overview
        findViewById<TextView>(R.id.tv_film_storyline_detail).text = storyline
        findViewById<TextView>(R.id.tv_film_genre_detail).text = genre
        findViewById<TextView>(R.id.tv_film_runtime_detail).text = runtime
        findViewById<TextView>(R.id.tv_film_rating_detail).text = rating
        val shareButton = findViewById<Button>(R.id.action_share)

        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Haloo lur ini link film bagus: $trailer")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, null))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}

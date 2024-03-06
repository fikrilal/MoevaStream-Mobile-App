package com.fikrilal.moevastream

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = "Ahmad Fikril Al Muzakki"
        val email = "fikrimuzakky24@gmail.com"
        val description =
            "Mobile Development Cohort at Bangkit Academy 2024 led by Google, Tokopedia, Gojek, & Traveloka"

        findViewById<TextView>(R.id.profile_name).text = name
        findViewById<TextView>(R.id.profile_email).text = email
        findViewById<TextView>(R.id.profile_description).text = description
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
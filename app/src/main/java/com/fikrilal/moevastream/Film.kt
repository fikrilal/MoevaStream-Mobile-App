package com.fikrilal.moevastream

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val name: String,
    val overview: String,
    val poster: Int,
    val storyline: String,
    val genre: String,
    val runtime: String,
    val rating: String,
    val trailer: String
): Parcelable

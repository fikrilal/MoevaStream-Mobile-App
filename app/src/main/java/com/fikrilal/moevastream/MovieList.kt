package com.fikrilal.moevastream

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieList(
    val title: String,
    val overview: String,
    val poster: Int
) : Parcelable

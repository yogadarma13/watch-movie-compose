package com.yogadarma.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val image: String,
    val title: String,
    val synopsis: String,
    val releaseDate: String,
    val rating: Double
) : Parcelable
package com.yogadarma.watchmovie.ui.screen.navigation

import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.yogadarma.core.data.source.remote.model.MovieResponse

val MovieNavType = object : NavType<MovieResponse>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): MovieResponse? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, MovieResponse::class.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): MovieResponse {
        return Gson().fromJson(value, MovieResponse::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: MovieResponse) {
        bundle.putParcelable(key, value)
    }
}
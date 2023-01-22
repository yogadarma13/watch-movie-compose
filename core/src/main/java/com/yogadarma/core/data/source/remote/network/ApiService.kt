package com.yogadarma.core.data.source.remote.network

import com.yogadarma.core.BuildConfig
import com.yogadarma.core.data.source.remote.model.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(BuildConfig.ENDPOINT_POPULAR_MOVIE)
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): ListMovieResponse
}
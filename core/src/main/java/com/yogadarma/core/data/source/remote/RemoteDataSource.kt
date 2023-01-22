package com.yogadarma.core.data.source.remote

import com.yogadarma.core.data.Resource
import com.yogadarma.core.data.source.remote.model.MovieResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getPopularMovie(): Flow<Resource<List<MovieResponse>>>
}
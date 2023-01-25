package com.yogadarma.core.domain.repository

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getPopularMovie(): Flow<Resource<List<Movie>>>
}
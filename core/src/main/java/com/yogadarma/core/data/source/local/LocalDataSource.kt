package com.yogadarma.core.data.source.local

import com.yogadarma.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllFavoriteMovie(): Flow<List<MovieEntity>>
}
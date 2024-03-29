package com.yogadarma.core.data.source.local

import com.yogadarma.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllFavoriteMovie(): Flow<List<MovieEntity>>

    fun insertFavorite(movieEntity: MovieEntity)

    fun checkFavoriteById(movieId: Int): Int

    fun deleteFavorite(movieId: Int)
}
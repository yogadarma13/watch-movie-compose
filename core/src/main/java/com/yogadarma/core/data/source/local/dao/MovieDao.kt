package com.yogadarma.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.yogadarma.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllFavoriteMovie(): Flow<List<MovieEntity>>
}
package com.yogadarma.core.data.source.local

import com.yogadarma.core.data.source.local.dao.MovieDao
import com.yogadarma.core.data.source.local.entity.MovieEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
) : LocalDataSource {

    override fun getAllFavoriteMovie() = movieDao.getAllFavoriteMovie()

    override fun insertFavorite(movieEntity: MovieEntity) = movieDao.insertFavorite(movieEntity)

    override fun checkFavoriteById(movieId: Int) = movieDao.checkFavoriteById(movieId)

    override fun deleteFavorite(movieId: Int) = movieDao.deleteFavorite(movieId)
}
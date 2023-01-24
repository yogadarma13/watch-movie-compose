package com.yogadarma.core.data.source.local

import com.yogadarma.core.data.source.local.dao.MovieDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
) : LocalDataSource {
}
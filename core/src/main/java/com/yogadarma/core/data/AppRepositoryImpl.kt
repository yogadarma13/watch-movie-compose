package com.yogadarma.core.data

import com.yogadarma.core.data.source.local.LocalDataSource
import com.yogadarma.core.data.source.remote.RemoteDataSource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.AppRepository
import com.yogadarma.core.utils.mapToDomain
import com.yogadarma.core.utils.mapToEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : AppRepository {

    override fun getPopularMovie(): Flow<Resource<List<Movie>>> = flow {
        remoteDataSource.getPopularMovie().collect { resource ->
            when (resource) {
                is Resource.Success -> {
                    val result = resource.data?.map {
                        it.mapToDomain()
                    }
                    emit(Resource.Success(result.orEmpty()))
                }
                is Resource.Error -> {
                    emit(Resource.Error(resource.message.toString()))
                }
            }
        }
    }

    override fun getAllFavoriteMovie(): Flow<List<Movie>> = flow {
        localDataSource.getAllFavoriteMovie().collect { list ->
            val result = list.map { it.mapToDomain() }
            emit(result)
        }
    }

    override suspend fun insertFavorite(movie: Movie) = withContext(Dispatchers.IO) {
        localDataSource.insertFavorite(movie.mapToEntity())
    }

    override suspend fun checkFavoriteById(movieId: Int) = withContext(Dispatchers.IO) {
        localDataSource.checkFavoriteById(movieId)
    }

    override suspend fun deleteFavorite(movieId: Int) = withContext(Dispatchers.IO) {
        localDataSource.deleteFavorite(movieId)
    }
}
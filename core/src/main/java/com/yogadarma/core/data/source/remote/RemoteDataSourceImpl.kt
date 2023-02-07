package com.yogadarma.core.data.source.remote

import android.content.Context
import com.yogadarma.core.R
import com.yogadarma.core.data.Resource
import com.yogadarma.core.data.source.remote.network.ApiService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    @ApplicationContext private val context: Context
) : RemoteDataSource {

    override fun getPopularMovie() = flow {
        try {
            val response = apiService.getPopularMovie()
            val movies = response.results.orEmpty()
            emit(Resource.Success(movies))
        } catch (e: Exception) {
            emit(Resource.Error(context.getString(R.string.failed_get_movie)))
        }
    }.flowOn(Dispatchers.IO)
}
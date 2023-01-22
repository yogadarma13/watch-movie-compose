package com.yogadarma.core.domain.usecases

import com.yogadarma.core.data.Resource
import com.yogadarma.core.data.source.remote.model.MovieResponse
import kotlinx.coroutines.flow.Flow

interface GetPopularMovieUseCase {
    fun invoke(): Flow<Resource<List<MovieResponse>>>
}
package com.yogadarma.core.domain.usecases

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMovieUseCase {
    fun invoke(): Flow<Resource<List<Movie>>>
}
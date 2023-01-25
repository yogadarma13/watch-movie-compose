package com.yogadarma.core.domain.usecases

import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetFavoriteUseCase {
    fun invoke(): Flow<List<Movie>>
}
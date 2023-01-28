package com.yogadarma.core.domain.usecases

import com.yogadarma.core.domain.model.Movie

interface InsertFavoriteUseCase {
    suspend fun invoke(movie: Movie)
}
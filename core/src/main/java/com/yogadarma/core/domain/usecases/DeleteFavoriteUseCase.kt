package com.yogadarma.core.domain.usecases

interface DeleteFavoriteUseCase {
    suspend fun invoke(movieId: Int)
}
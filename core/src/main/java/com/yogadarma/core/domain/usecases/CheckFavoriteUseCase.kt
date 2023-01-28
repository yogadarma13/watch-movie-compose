package com.yogadarma.core.domain.usecases

interface CheckFavoriteUseCase {
    suspend fun invoke(movieId: Int): Int
}
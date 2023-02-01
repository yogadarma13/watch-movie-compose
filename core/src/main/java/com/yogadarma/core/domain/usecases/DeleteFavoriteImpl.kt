package com.yogadarma.core.domain.usecases

import com.yogadarma.core.domain.repository.AppRepository
import javax.inject.Inject

class DeleteFavoriteImpl @Inject constructor(private val repository: AppRepository) :
    DeleteFavoriteUseCase {

    override suspend fun invoke(movieId: Int) = repository.deleteFavorite(movieId)
}
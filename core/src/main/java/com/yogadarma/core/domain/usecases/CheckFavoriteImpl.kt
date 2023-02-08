package com.yogadarma.core.domain.usecases

import com.yogadarma.core.domain.repository.AppRepository
import javax.inject.Inject

class CheckFavoriteImpl @Inject constructor(private val repository: AppRepository) :
    CheckFavoriteUseCase {

    override suspend fun invoke(movieId: Int) = repository.checkFavoriteById(movieId)
}
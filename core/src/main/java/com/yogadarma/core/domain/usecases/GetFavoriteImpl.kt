package com.yogadarma.core.domain.usecases

import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteImpl @Inject constructor(private val appRepository: AppRepository) : GetFavoriteUseCase {
    override fun invoke() = appRepository.getAllFavoriteMovie()
}
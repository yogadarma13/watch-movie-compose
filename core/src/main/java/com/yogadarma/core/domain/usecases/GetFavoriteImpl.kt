package com.yogadarma.core.domain.usecases

import com.yogadarma.core.domain.repository.AppRepository
import javax.inject.Inject

class GetFavoriteImpl @Inject constructor(private val appRepository: AppRepository) :
    GetFavoriteUseCase {
    override fun invoke() = appRepository.getAllFavoriteMovie()
}
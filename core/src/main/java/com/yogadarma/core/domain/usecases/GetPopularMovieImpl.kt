package com.yogadarma.core.domain.usecases

import com.yogadarma.core.domain.repository.AppRepository
import javax.inject.Inject

class GetPopularMovieImpl @Inject constructor(private val repository: AppRepository) :
    GetPopularMovieUseCase {

    override fun invoke() = repository.getPopularMovie()
}
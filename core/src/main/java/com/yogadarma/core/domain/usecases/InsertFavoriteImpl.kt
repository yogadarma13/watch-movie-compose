package com.yogadarma.core.domain.usecases

import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.AppRepository
import javax.inject.Inject

class InsertFavoriteImpl @Inject constructor(private val repository: AppRepository) :
    InsertFavoriteUseCase {

    override suspend fun invoke(movie: Movie) = repository.insertFavorite(movie)
}
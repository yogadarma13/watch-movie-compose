package com.yogadarma.core.utils

import com.yogadarma.core.data.source.remote.model.MovieResponse
import com.yogadarma.core.domain.model.Movie

fun MovieResponse.mapToDomain() = Movie(
    posterPath.orEmpty(),
    originalTitle.orEmpty(),
    overview.orEmpty(),
    releaseDate.orEmpty(),
    voteAverage ?: 0.0
)

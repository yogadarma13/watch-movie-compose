package com.yogadarma.core.utils

import com.yogadarma.core.data.source.local.entity.MovieEntity
import com.yogadarma.core.data.source.remote.model.MovieResponse
import com.yogadarma.core.domain.model.Movie

fun MovieResponse.mapToDomain() = Movie(
    posterPath.orEmpty(),
    originalTitle.orEmpty(),
    overview.orEmpty(),
    releaseDate.orEmpty(),
    voteAverage ?: 0.0
)

fun MovieEntity.mapToDomain() = Movie(
    image,
    title,
    synopsis,
    releaseDate,
    rating
)

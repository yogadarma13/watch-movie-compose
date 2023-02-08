package com.yogadarma.watchmovie.utils

import com.yogadarma.core.domain.model.Movie

object DummyData {
    fun getDummyMovieList() = listOf(
        Movie(
            movieId = 1,
            image = "image1.jpg",
            title = "Movie 1",
            synopsis = "Synopsis Movie 1",
            releaseDate = "2023-01-07",
            rating = 9.7
        ),
        Movie(
            movieId = 2,
            image = "image2.jpg",
            title = "Movie 2",
            synopsis = "Synopsis Movie 2",
            releaseDate = "2022-07-07",
            rating = 9.5
        ),
        Movie(
            movieId = 3,
            image = "image3.jpg",
            title = "Movie 3",
            synopsis = "Synopsis Movie 3",
            releaseDate = "2022-10-04",
            rating = 8.6
        )
    )
}
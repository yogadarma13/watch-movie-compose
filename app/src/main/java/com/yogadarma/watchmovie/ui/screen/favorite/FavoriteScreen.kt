package com.yogadarma.watchmovie.ui.screen.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.common.UiState
import com.yogadarma.watchmovie.ui.component.EmptyContent
import com.yogadarma.watchmovie.ui.component.ItemMovieVertical
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel(),
    navigateToDetail: (Movie) -> Unit = {}
) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { state ->
        when (state) {
            is UiState.Loading -> viewModel.getAllFavoriteMovie()
            is UiState.Success -> {
                if (state.data.isNotEmpty())
                    FavoriteContent(
                        modifier = modifier,
                        movies = state.data,
                        navigateToDetail = navigateToDetail
                    )
                else
                    EmptyContent(message = stringResource(id = R.string.empty_favorite_data))
            }
            else -> {}
        }
    }
}

@Composable
fun FavoriteContent(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    navigateToDetail: (Movie) -> Unit
) {
    LazyColumn(
        modifier = modifier.testTag("FavoriteList"),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
    ) {
        items(movies, key = { it.movieId }) { data ->
            ItemMovieVertical(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navigateToDetail(data) }
                    .testTag("FavoriteItem"),
                image = data.image,
                title = data.title,
                rating = data.rating.toString(),
                releaseDate = data.releaseDate
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    WatchMovieTheme {
        FavoriteScreen()
    }
}
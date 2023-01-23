package com.yogadarma.watchmovie.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yogadarma.core.data.source.remote.model.MovieResponse
import com.yogadarma.watchmovie.common.UiState
import com.yogadarma.watchmovie.ui.component.CircularProgress
import com.yogadarma.watchmovie.ui.component.ErrorContent
import com.yogadarma.watchmovie.ui.component.ItemMovieGrid
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (MovieResponse) -> Unit = {}
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { state ->
        when (state) {
            is UiState.Loading -> {
                viewModel.getPopularMovie()
                CircularProgress()
            }
            is UiState.Success -> {
                HomeContent(
                    modifier = modifier,
                    movies = state.data,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {
                ErrorContent(errorMessage = state.errorMessage)
            }
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    movies: List<MovieResponse>,
    navigateToDetail: (MovieResponse) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    LazyVerticalGrid(modifier = modifier, columns = GridCells.Adaptive(150.dp)) {
        items(movies) { data ->
            ItemMovieGrid(
                modifier = Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { navigateToDetail(data) },
                image = data.posterPath.orEmpty(),
                title = data.originalTitle.orEmpty(),
                releaseDate = data.releaseDate.orEmpty()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    WatchMovieTheme {
        HomeScreen()
    }
}
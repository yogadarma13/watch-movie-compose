package com.yogadarma.watchmovie.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.watchmovie.common.UiState
import com.yogadarma.watchmovie.ui.component.CircularProgress
import com.yogadarma.watchmovie.ui.component.ErrorContent
import com.yogadarma.watchmovie.ui.component.ItemMovieGrid
import com.yogadarma.watchmovie.ui.component.SearchBar
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (Movie) -> Unit = {}
) {
    val query by viewModel.query

    Column(modifier = modifier.fillMaxSize()) {
        SearchBar(query = query, onValueChange = viewModel::searchMovie)
        viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { state ->
            when (state) {
                is UiState.Loading -> {
                    CircularProgress()
                }
                is UiState.Success -> {
                    HomeContent(
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

}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    navigateToDetail: (Movie) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    LazyVerticalGrid(
        modifier = modifier.testTag("MovieList"),
        columns = GridCells.Adaptive(150.dp)
    ) {
        items(movies, key = { it.movieId }) { data ->
            ItemMovieGrid(
                modifier = Modifier
                    .testTag("MovieItem")
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { navigateToDetail(data) },
                image = data.image,
                title = data.title,
                releaseDate = data.releaseDate
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
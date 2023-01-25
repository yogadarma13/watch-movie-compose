package com.yogadarma.watchmovie.ui.screen.favorite

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.yogadarma.watchmovie.common.UiState
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel()
) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { state ->
        when(state) {
            is UiState.Loading -> viewModel.getAllFavoriteMovie()
            is UiState.Success -> Log.d("DATAAAAAA", state.data.toString())
            else -> {}
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Favorite")
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    WatchMovieTheme {
        FavoriteScreen()
    }
}
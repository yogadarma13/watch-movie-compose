package com.yogadarma.watchmovie.ui.screen.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier
) {
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
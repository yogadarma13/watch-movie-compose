package com.yogadarma.watchmovie.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogadarma.watchmovie.ui.component.ItemMovieGrid
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }

    LazyVerticalGrid(modifier = modifier, columns = GridCells.Adaptive(140.dp)) {
        items(10) {
            ItemMovieGrid(
                modifier = Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    navigateToDetail()
                })
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
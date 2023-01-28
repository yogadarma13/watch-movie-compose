package com.yogadarma.watchmovie.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.component.SectionDetailMovie
import com.yogadarma.watchmovie.ui.component.SectionPosterMovie
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
    movie: Movie? = null,
    navigateBack: () -> Unit = {}
) {
    var favorite by remember { mutableStateOf(false) }

    viewModel.favState.collectAsState().value.let { favorite = it }
    viewModel.checkFavoriteById(movie?.movieId ?: 0)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            SectionPosterMovie(
                image = movie?.image.orEmpty(),
                title = movie?.title.orEmpty()
            )
            SectionDetailMovie(
                rating = movie?.rating.toString(),
                releaseDate = movie?.releaseDate.orEmpty(),
                synopsis = movie?.synopsis.orEmpty()
            )
        }
        Row(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                modifier = Modifier
                    .background(shape = CircleShape, color = colorResource(id = R.color.white_50))
                    .size(40.dp),
                onClick = { navigateBack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_button_description)
                )
            }
            IconButton(
                modifier = Modifier
                    .background(shape = CircleShape, color = colorResource(id = R.color.white_50))
                    .size(40.dp),
                onClick = {
                    movie?.let {
                        viewModel.insertFavorite(it)
                    }
                }
            ) {
                Icon(
                    imageVector = if (favorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(id = R.string.favorite_button_description)
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun DetailScreenPreview() {
    WatchMovieTheme {
        DetailScreen()
    }
}
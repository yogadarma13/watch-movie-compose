package com.yogadarma.watchmovie.ui.screen.detail

import android.util.Log
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogadarma.core.data.source.remote.model.MovieResponse
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.component.SectionDetailMovie
import com.yogadarma.watchmovie.ui.component.SectionPosterMovie
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier, movie: MovieResponse? = null) {
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
            SectionPosterMovie()
            SectionDetailMovie()
        }
        IconButton(
            modifier = Modifier
                .padding(16.dp)
                .background(shape = CircleShape, color = colorResource(id = R.color.white_50))
                .size(40.dp),
            onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.back_button_description)
            )
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
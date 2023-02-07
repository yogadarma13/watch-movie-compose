package com.yogadarma.watchmovie.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yogadarma.watchmovie.BuildConfig
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun SectionPosterMovie(modifier: Modifier = Modifier, image: String, title: String) {
    Box(modifier = modifier.testTag("MoviePoster"), contentAlignment = Alignment.BottomStart) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.75f),
            model = "${BuildConfig.BASE_IMAGE_URL}$image",
            contentDescription = stringResource(id = R.string.movie_poster_description),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White
                        )
                    )
                )
        )
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag("MovieTitle"),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.Bold
            ),
        )
    }
}

@Preview
@Composable
fun SectionPosterMoviePreview() {
    WatchMovieTheme {
        SectionPosterMovie(image = "", title = "")
    }
}
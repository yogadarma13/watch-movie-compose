package com.yogadarma.watchmovie.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogadarma.watchmovie.BuildConfig
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme
import com.yogadarma.watchmovie.utils.formatDate

@Composable
fun SectionDetailMovie(
    modifier: Modifier = Modifier,
    rating: String,
    releaseDate: String,
    synopsis: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        DrawableStartWrapper(
            drawable = R.drawable.ic_star,
            drawablePadding = 8.dp
        ) {
            Text(
                text = rating,
                style = MaterialTheme.typography.h6,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        DrawableStartWrapper(drawable = R.drawable.ic_date, drawablePadding = 8.dp) {
            Text(
                text = releaseDate.formatDate(
                    BuildConfig.FORMAT_DATE1,
                    BuildConfig.FORMAT_DATE3
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.label_synopsis),
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            text = synopsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionDetailMoviePreview() {
    WatchMovieTheme {
        SectionDetailMovie(rating = "", releaseDate = "", synopsis = "")
    }
}
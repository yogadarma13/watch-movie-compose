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
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun SectionDetailMovie(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "action",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        DrawableStartWrapper(
            modifier = Modifier.padding(horizontal = 16.dp),
            drawable = R.drawable.ic_star,
            drawablePadding = 8.dp
        ) {
            Text(
                text = "75%",
                style = MaterialTheme.typography.h6,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            DrawableStartWrapper(drawable = R.drawable.ic_date, drawablePadding = 8.dp) {
                Text(text = "01/07/1999")
            }
            Spacer(modifier = Modifier.width(24.dp))
            DrawableStartWrapper(drawable = R.drawable.ic_time, drawablePadding = 8.dp) {
                Text(text = "1h 42m")
            }
        }
        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
            text = stringResource(id = R.string.label_synopsis),
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 8.dp
                ), text = "Lorem ipsum"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionDetailMoviePreview() {
    WatchMovieTheme {
        SectionDetailMovie()
    }
}
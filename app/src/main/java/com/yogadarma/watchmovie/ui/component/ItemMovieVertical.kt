package com.yogadarma.watchmovie.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yogadarma.watchmovie.BuildConfig
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme
import com.yogadarma.watchmovie.utils.formatDate

@Composable
fun ItemMovieVertical(
    modifier: Modifier = Modifier,
    image: String,
    title: String,
    releaseDate: String
) {
    Row(modifier = modifier.padding(vertical = 8.dp)) {
        AsyncImage(
            model = "${BuildConfig.BASE_IMAGE_URL}$image",
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(140.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = releaseDate.formatDate(BuildConfig.FORMAT_DATE1, BuildConfig.FORMAT_DATE2),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}

@Preview
@Composable
fun ItemMovieVerticalPreview() {
    WatchMovieTheme {
        ItemMovieVertical(image = "", title = "Title", releaseDate = "2021-12-12")
    }
}
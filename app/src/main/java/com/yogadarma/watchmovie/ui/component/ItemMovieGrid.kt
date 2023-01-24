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
fun ItemMovieGrid(
    modifier: Modifier = Modifier,
    image: String,
    title: String,
    releaseDate: String
) {
    Column(modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        AsyncImage(
            model = "${BuildConfig.BASE_IMAGE_URL}$image",
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.75f)
                .clip(shape = RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            maxLines = 1,
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

@Preview(showBackground = true)
@Composable
fun ItemMovieGridPreview() {
    WatchMovieTheme {
        ItemMovieGrid(image = "", title = "", releaseDate = "")
    }
}
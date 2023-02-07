package com.yogadarma.watchmovie.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun EmptyContent(modifier: Modifier = Modifier, message: String) {
    Column(
        modifier = modifier.fillMaxSize().testTag("EmptyContent"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(250.dp),
            painter = painterResource(id = R.drawable.ic_empty),
            contentDescription = stringResource(id = R.string.empty_description)
        )
        Text(
            modifier = modifier.padding(horizontal = 16.dp),
            text = message,
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyContentPreview() {
    WatchMovieTheme {
        EmptyContent(message = stringResource(id = R.string.empty_favorite_data))
    }
}
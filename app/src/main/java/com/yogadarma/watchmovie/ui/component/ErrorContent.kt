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
fun ErrorContent(modifier: Modifier = Modifier, errorMessage: String) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("ErrorContent"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(250.dp)
                .testTag("ErrorImage"),
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = stringResource(id = R.string.error_description)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .testTag("ErrorMessage"),
            text = errorMessage,
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorContentPreview() {
    WatchMovieTheme {
        ErrorContent(errorMessage = "Error")
    }
}
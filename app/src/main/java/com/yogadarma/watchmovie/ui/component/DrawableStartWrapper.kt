package com.yogadarma.watchmovie.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun DrawableStartWrapper(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    drawablePadding: Dp,
    content: @Composable () -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = drawable), contentDescription = null)
        Spacer(modifier = Modifier.width(drawablePadding))
        content()
    }
}

@Preview
@Composable
fun DrawableStartWrapperPreview() {
    WatchMovieTheme {
        DrawableStartWrapper(drawable = R.drawable.ic_star, drawablePadding = 16.dp) {
            Text(
                text = "75%",
                style = MaterialTheme.typography.h6,
            )
        }
    }
}
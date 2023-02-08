package com.yogadarma.watchmovie.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Red,
    primaryVariant = Red,
    secondary = Black200,
    background = Black,
    secondaryVariant = BlackOpacity50
)

private val LightColorPalette = lightColors(
    primary = Red,
    primaryVariant = Red,
    secondary = LightGrey,
    background = White,
    secondaryVariant = WhiteOpacity50
)

@Composable
fun WatchMovieTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
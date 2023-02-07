package com.yogadarma.watchmovie.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yogadarma.watchmovie.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.red))
            .testTag("SplashScreenPage"),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_splash),
            contentDescription = stringResource(id = R.string.icon_splash_description),
            Modifier.size(180.dp)
        )
        LaunchedEffect(true) {
            delay(3000)
            navigateToHome()
        }
    }
}
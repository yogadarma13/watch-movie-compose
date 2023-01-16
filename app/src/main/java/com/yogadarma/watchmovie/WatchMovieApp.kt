package com.yogadarma.watchmovie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yogadarma.watchmovie.ui.screen.home.HomeScreen
import com.yogadarma.watchmovie.ui.screen.navigation.Screen
import com.yogadarma.watchmovie.ui.screen.splash.SplashScreen
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun WatchMovieApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WatchMovieAppPreview() {
    WatchMovieTheme {
        WatchMovieApp()
    }
}
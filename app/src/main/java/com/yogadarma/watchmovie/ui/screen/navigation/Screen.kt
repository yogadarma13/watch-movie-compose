package com.yogadarma.watchmovie.ui.screen.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object Profile : Screen("profile")
}

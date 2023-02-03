package com.yogadarma.watchmovie.ui.screen.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("Splash")
    object Home : Screen("Home")
    object Favorite : Screen("Favorite")
    object About : Screen("About")
    object Detail : Screen("Detail/{movie}") {
        fun createRoute(movieJson: String) = "Detail/$movieJson"
    }
}

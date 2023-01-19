package com.yogadarma.watchmovie

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yogadarma.watchmovie.ui.screen.favorite.FavoriteScreen
import com.yogadarma.watchmovie.ui.screen.home.HomeScreen
import com.yogadarma.watchmovie.ui.screen.navigation.NavigationItem
import com.yogadarma.watchmovie.ui.screen.navigation.Screen
import com.yogadarma.watchmovie.ui.screen.profile.ProfileScreen
import com.yogadarma.watchmovie.ui.screen.splash.SplashScreen
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun WatchMovieApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Splash.route) {
                BottomNavigationBar(navController = navController)
            }
        },
        modifier = modifier
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(navController = navController)
            }
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Favorite.route) {
                FavoriteScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Composable
private fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = stringResource(R.string.title_movie),
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = stringResource(R.string.title_favorite),
            icon = Icons.Default.Favorite,
            screen = Screen.Favorite
        ),
        NavigationItem(
            title = stringResource(R.string.title_profile),
            icon = Icons.Default.AccountCircle,
            screen = Screen.Profile
        ),
    )
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colors.primary
    ) {
        navigationItems.map { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        navController.popBackStack()
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
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
package com.yogadarma.watchmovie

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.*
import org.junit.runners.MethodSorters

@HiltAndroidTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class WatchMovieAppTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun test1_navHost_checkSplashScreenIsDisplayed() {
        composeTestRule.onNodeWithTag("SplashScreenPage").assertIsDisplayed()
    }

    @Test
    fun test2_navHost_checkMovieListIsDisplayed() {
        composeTestRule.run {
            waitUntil(10000L) {
                onAllNodesWithTag("MovieList").fetchSemanticsNodes().size == 1
            }
            onNodeWithTag("MovieList").assertIsDisplayed()
            onNodeWithTag("MovieList").performScrollToIndex(10)
        }
    }

    @Test
    fun test3_navHost_clickMovieItem_navigateToDetailScreen() {
        composeTestRule.run {
            waitUntil(10000L) {
                onAllNodesWithTag("MovieList").fetchSemanticsNodes().size == 1
            }
            onNodeWithTag("MovieList").performScrollToIndex(10)
            onAllNodesWithTag("MovieItem").onFirst().performClick()
            onNodeWithTag("MoviePoster").assertIsDisplayed()
            onNodeWithTag("MovieTitle").assertIsDisplayed()
            onNodeWithTag("MovieRating").assertIsDisplayed()
            onNodeWithTag("MovieReleaseDate").assertIsDisplayed()
            onNodeWithTag("MovieSynopsisLabel").assertIsDisplayed()
            onNodeWithTag("MovieSynopsis").assertIsDisplayed()
        }
    }

    @Test
    fun test4_navHost_clickFavoriteButton_addAndDeleteFavorite() {
        composeTestRule.run {
            waitUntil(10000L) {
                onAllNodesWithTag("MovieList").fetchSemanticsNodes().size == 1
            }
            onNodeWithTag("MovieList").performScrollToIndex(10)
            onAllNodesWithTag("MovieItem").onFirst().performClick()
            onNodeWithTag("FavoriteButton").performClick()
            onNodeWithTag("DetailBackButton").performClick()
            onNodeWithText("Favorite").performClick()
            onNodeWithTag("FavoriteList").assertIsDisplayed()
            onAllNodesWithTag("FavoriteItem").onFirst().performClick()
            onNodeWithTag("MoviePoster").assertIsDisplayed()
            onNodeWithTag("MovieTitle").assertIsDisplayed()
            onNodeWithTag("MovieRating").assertIsDisplayed()
            onNodeWithTag("MovieReleaseDate").assertIsDisplayed()
            onNodeWithTag("MovieSynopsisLabel").assertIsDisplayed()
            onNodeWithTag("MovieSynopsis").assertIsDisplayed()
            onNodeWithTag("FavoriteButton").performClick()
            onNodeWithTag("DetailBackButton").performClick()
            onNodeWithTag("EmptyContent").assertIsDisplayed()
        }
    }

    @Test
    fun test5_navHost_clickAboutTab_displayAboutPage() {
        composeTestRule.run {
            waitUntil(10000L) {
                onAllNodesWithTag("MovieList").fetchSemanticsNodes().size == 1
            }
            onNodeWithText("About").performClick()
            onNodeWithTag("DeveloperImage").assertIsDisplayed()
            onNodeWithTag("DeveloperName").assertIsDisplayed()
            onNodeWithTag("DeveloperEmail").assertIsDisplayed()
            onNodeWithTag("CopyrightLabel").assertIsDisplayed()
        }
    }
}
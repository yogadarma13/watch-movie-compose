package com.yogadarma.watchmovie.ui.screen.home

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.yogadarma.watchmovie.MainActivity
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme
import com.yogadarma.watchmovie.utils.DummyData
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class HomeContentTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Before
    fun setup() {
        composeTestRule.activity.setContent {
            WatchMovieTheme {
                HomeContent(movies = DummyData.getDummyMovieList(), navigateToDetail = {})
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun homeContent_isDisplayed() {
        composeTestRule.run {
            onNodeWithTag("MovieList").assertIsDisplayed()
            onNodeWithTag("MovieList").performScrollToIndex(2)
            onAllNodesWithTag("MovieItem").onFirst().assertIsDisplayed()
            onAllNodesWithTag("MovieItem").onFirst().assertHasClickAction()
        }
    }
}
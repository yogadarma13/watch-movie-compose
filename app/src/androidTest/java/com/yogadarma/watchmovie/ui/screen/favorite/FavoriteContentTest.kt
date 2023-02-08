package com.yogadarma.watchmovie.ui.screen.favorite

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
class FavoriteContentTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Before
    fun setup() {
        composeTestRule.activity.setContent {
            WatchMovieTheme {
                FavoriteContent(movies = DummyData.getDummyMovieList(), navigateToDetail = {})
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun favoriteContent_isDisplayed() {
        composeTestRule.run {
            onNodeWithTag("FavoriteList").assertIsDisplayed()
            onNodeWithTag("FavoriteList").performScrollToIndex(2)
            onAllNodesWithTag("FavoriteItem").onFirst().assertIsDisplayed()
            onAllNodesWithTag("FavoriteItem").onFirst().assertHasClickAction()
        }
    }
}
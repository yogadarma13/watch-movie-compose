package com.yogadarma.watchmovie.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.hilt.navigation.compose.hiltViewModel
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.watchmovie.MainActivity
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class DetailScreenTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    private val fakeMovieData = Movie(
        movieId = 2,
        image = "image2.jpg",
        title = "Movie 2",
        synopsis = "Synopsis Movie 2",
        releaseDate = "2022-07-07",
        rating = 9.5
    )

    @Before
    fun setup() {
        composeTestRule.activity.setContent {
            WatchMovieTheme {
                DetailScreen(
                    movie = fakeMovieData,
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun detailPage_isDisplayed() {
        composeTestRule.run {
            onNodeWithTag("MoviePoster").assertIsDisplayed()
            onNodeWithTag("MovieTitle").assertIsDisplayed()
            onNodeWithTag("MovieRating").assertIsDisplayed()
            onNodeWithTag("MovieReleaseDate").assertIsDisplayed()
            onNodeWithTag("MovieSynopsisLabel").assertIsDisplayed()
            onNodeWithTag("MovieSynopsis").assertIsDisplayed()
        }
    }
}
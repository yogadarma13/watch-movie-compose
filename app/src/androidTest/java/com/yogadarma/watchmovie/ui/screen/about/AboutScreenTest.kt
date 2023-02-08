package com.yogadarma.watchmovie.ui.screen.about

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.yogadarma.watchmovie.MainActivity
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AboutScreenTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Before
    fun setup() {
        composeTestRule.activity.setContent {
            WatchMovieTheme {
                AboutScreen()
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun aboutPage_isDisplayed() {
        composeTestRule.run {
            onNodeWithTag("DeveloperImage").assertIsDisplayed()
            onNodeWithTag("DeveloperName").assertIsDisplayed()
            onNodeWithText("I Kadek Yoga Darma Putra").assertIsDisplayed()
            onNodeWithTag("DeveloperEmail").assertIsDisplayed()
            onNodeWithText("kadekyoga125@gmail.com").assertIsDisplayed()
            onNodeWithTag("CopyrightLabel").assertIsDisplayed()
        }
    }
}
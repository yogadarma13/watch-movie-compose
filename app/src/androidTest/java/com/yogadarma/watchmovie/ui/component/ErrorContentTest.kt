package com.yogadarma.watchmovie.ui.component

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ErrorContentTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ErrorContent(errorMessage = "Not found")
        }
    }

    @Test
    fun errorContent_isDisplayed() {
        composeTestRule.run {
            onNodeWithTag("ErrorContent").assertIsDisplayed()
            onNodeWithTag("ErrorImage").assertIsDisplayed()
            onNodeWithTag("ErrorMessage").assertIsDisplayed()
            onNodeWithTag("ErrorMessage").assertTextEquals("Not found")
        }
    }
}
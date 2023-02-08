package com.yogadarma.watchmovie.ui.component

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmptyContentTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            EmptyContent(message = "Data Kosong")
        }
    }

    @Test
    fun emptyContent_isDisplayed() {
        composeTestRule.run {
            onNodeWithTag("EmptyContent").assertIsDisplayed()
            onNodeWithTag("EmptyImage").assertIsDisplayed()
            onNodeWithTag("EmptyMessage").assertIsDisplayed()
            onNodeWithTag("EmptyMessage").assertTextEquals("Data Kosong")
        }
    }
}
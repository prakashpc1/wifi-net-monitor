package com.example.networkmonitor

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.networkmonitor.ui.theme.NetworkMonitorAppTheme
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun mainScreen_displaysContent() {
        composeTestRule.setContent {
            NetworkMonitorAppTheme {
                MainScreen() // Assuming MainScreen is simple for this example
            }
        }
        // This is a placeholder, as MainScreen() is currently empty.
        // You would look for specific text or components.
        // For example, if MainScreen had a title:
        // composeTestRule.onNodeWithText("Network Monitor").assertIsDisplayed()
    }
}
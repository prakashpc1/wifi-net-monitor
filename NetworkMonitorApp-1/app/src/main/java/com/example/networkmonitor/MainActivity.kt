package com.example.networkmonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.networkmonitor.ui.theme.NetworkMonitorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkMonitorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    // TODO: Implement the main screen layout and fragment setup for WiFi and mobile data analysis
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NetworkMonitorAppTheme {
        MainScreen()
    }
}
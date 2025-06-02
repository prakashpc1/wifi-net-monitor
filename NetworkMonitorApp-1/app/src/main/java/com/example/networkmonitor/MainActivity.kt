package com.example.networkmonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.networkmonitor.ui.theme.NetworkMonitorAppTheme
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import android.Manifest

class MainActivity : ComponentActivity() {
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your app.
            } else {
                // Explain to the user that the feature is unavailable because the
                // features requires a permission that the user has denied.
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkMonitorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    MainScreen()
                }
                // Example for requesting a permission (e.g., FINE_LOCATION if needed)
                // You'd typically call this when a feature requiring the permission is accessed.
                // RequestPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }

    @Composable
    fun RequestPermission(permission: String) {
        LaunchedEffect(Unit) {
            when {
                ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    permission
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // Permission is already granted
                }
                shouldShowRequestPermissionRationale(permission) -> {
                    // Show an educational UI to the user
                    // Then, request the permission
                    // requestPermissionLauncher.launch(permission)
                }
                else -> {
                    // Directly request the permission
                    requestPermissionLauncher.launch(permission)
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
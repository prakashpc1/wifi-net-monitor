/**
 * Fetches network usage statistics.
 * @param forceRefresh If true, fetches fresh data from the source, otherwise might return cached data.
 * @return A [NetworkUsageStats] object.
 * @throws IOException If there is a network error.
 */
suspend fun getNetworkUsageStats(forceRefresh: Boolean = false): NetworkUsageStatspackage com.example.networkmonitor.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DataUsageBar(
    used: Long,
    limit: Long,
    barColor: Color = Color.Blue,
    backgroundColor: Color = Color.LightGray,
    modifier: Modifier = Modifier
) {
    val percentage = if (limit > 0) (used.toFloat() / limit.toFloat()).coerceIn(0f, 1f) else 0f

    Column(modifier = modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Used: ${formatBytes(used)}", fontSize = 12.sp)
            Text(text = "Limit: ${formatBytes(limit)}", fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Box(modifier = Modifier.fillMaxWidth().height(20.dp)) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(
                    color = backgroundColor,
                    size = size
                )
                drawRect(
                    color = barColor,
                    size = Size(width = size.width * percentage, height = size.height)
                )
            }
        }
    }
}

// Helper to format bytes (simple version)
fun formatBytes(bytes: Long): String {
    return when {
        bytes < 1024 -> "$bytes B"
        bytes < 1024 * 1024 -> "${bytes / 1024} KB"
        bytes < 1024 * 1024 * 1024 -> "${bytes / (1024 * 1024)} MB"
        else -> "${bytes / (1024 * 1024 * 1024)} GB"
    }
}
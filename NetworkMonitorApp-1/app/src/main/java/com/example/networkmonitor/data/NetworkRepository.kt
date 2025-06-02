package com.example.networkmonitor.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkRepository(private val context: Context) {

    /**
     * Retrieves the current network usage statistics for both WiFi and mobile data.
     * This is a suspend function and should be called from a coroutine.
     *
     * @return [NetworkUsageStats] containing WiFi and mobile usage.
     */
    suspend fun getNetworkUsageStats(): NetworkUsageStats = withContext(Dispatchers.IO) {
        // Logic to fetch network usage statistics
        // This is a placeholder for actual implementation
        // Ensure this part is well-documented if complex (e.g., how TrafficStats is used)
        NetworkUsageStats(
            wifiUsage = getWifiUsage(),
            mobileUsage = getMobileUsage()
        )
    }

    /**
     * Placeholder for actual WiFi usage fetching logic.
     * TODO: Implement actual data retrieval.
     */
    private fun getWifiUsage(): Long {
        // Placeholder for actual WiFi usage fetching logic
        return 0L // Example: TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes()
    }

    /**
     * Placeholder for actual mobile data usage fetching logic.
     * TODO: Implement actual data retrieval.
     */
    private fun getMobileUsage(): Long {
        // Placeholder for actual mobile data usage fetching logic
        return 0L // Example: TrafficStats.getMobileRxBytes()
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork?.let {
                connectivityManager.getNetworkCapabilities(it)
            }
            networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
        } else {
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            activeNetwork?.isConnected == true
        }
    }
}

data class NetworkUsageStats(
    val wifiUsage: Long,
    val mobileUsage: Long
)
}
package com.example.networkmonitor.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkRepository(private val context: Context) {

    suspend fun getNetworkUsageStats(): NetworkUsageStats = withContext(Dispatchers.IO) {
        // Logic to fetch network usage statistics
        // This is a placeholder for actual implementation
        NetworkUsageStats(
            wifiUsage = getWifiUsage(),
            mobileUsage = getMobileUsage()
        )
    }

    private fun getWifiUsage(): Long {
        // Placeholder for actual WiFi usage fetching logic
        return 0L
    }

    private fun getMobileUsage(): Long {
        // Placeholder for actual mobile data usage fetching logic
        return 0L
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
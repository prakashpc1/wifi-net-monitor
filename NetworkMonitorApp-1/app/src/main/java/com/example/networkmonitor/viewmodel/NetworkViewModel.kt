package com.example.networkmonitor.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.networkmonitor.data.NetworkRepository

class NetworkViewModel(private val repository: NetworkRepository) : ViewModel() {

    private val _wifiUsage = MutableLiveData<NetworkUsage>()
    val wifiUsage: LiveData<NetworkUsage> get() = _wifiUsage

    private val _mobileUsage = MutableLiveData<NetworkUsage>()
    val mobileUsage: LiveData<NetworkUsage> get() = _mobileUsage

    init {
        fetchNetworkUsage()
    }

    private fun fetchNetworkUsage() {
        // Fetch WiFi and mobile network usage from the repository
        _wifiUsage.value = repository.getWifiUsage()
        _mobileUsage.value = repository.getMobileUsage()
    }

    fun refreshNetworkUsage() {
        fetchNetworkUsage()
    }
}

data class NetworkUsage(
    val dataUsed: Long,
    val dataLimit: Long
)
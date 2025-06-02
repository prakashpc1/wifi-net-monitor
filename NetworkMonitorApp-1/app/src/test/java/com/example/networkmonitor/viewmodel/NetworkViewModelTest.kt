package com.example.networkmonitor.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.networkmonitor.data.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Assert.*

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NetworkViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule() // For LiveData

    private val testDispatcher = UnconfinedTestDispatcher() // StandardTestDispatcher() if you need control

    @Mock
    private lateinit var repository: NetworkRepository

    private lateinit var viewModel: NetworkViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        // Mock repository responses BEFORE viewModel is initialized if init block uses them
        // For this example, let's assume NetworkRepository.getWifiUsage() returns NetworkUsage
        // `when`(repository.getWifiUsage()).thenReturn(NetworkUsage(100L, 1000L))
        // `when`(repository.getMobileUsage()).thenReturn(NetworkUsage(50L, 500L))
        
        viewModel = NetworkViewModel(repository)
    }

    @Test
    fun `fetchNetworkUsage updates LiveData`() = runTest {
        // Given
        val wifiData = NetworkUsage(1024L, 2048L)
        val mobileData = NetworkUsage(512L, 1024L)
        `when`(repository.getWifiUsage()).thenReturn(wifiData)
        `when`(repository.getMobileUsage()).thenReturn(mobileData)

        // When
        viewModel.refreshNetworkUsage() // Or rely on init if that's the behavior

        // Then
        assertEquals(wifiData, viewModel.wifiUsage.value)
        assertEquals(mobileData, viewModel.mobileUsage.value)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
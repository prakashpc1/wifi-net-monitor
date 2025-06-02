# Network Monitor App

## Overview
The Network Monitor App is an Android application designed to provide comprehensive monitoring, analysis, and control of network utilization for both WiFi and mobile networks. The app features a user-friendly interface inspired by Samsung's One UI, with support for both light and dark themes.

## Features
- Real-time monitoring of network usage for WiFi and mobile data.
- Detailed analysis of network statistics.
- User-friendly interface with a modern design.
- Support for light and dark modes.
- Intuitive components for displaying network usage statistics.

## Installation
1. Clone the repository:
   ```
   https://github.com/prakashpc1/wifi-net-monitor.git
   ```
2. Open the project in your preferred IDE.
3. Ensure you have the latest version of Android Studio and the necessary SDKs installed.
4. Build the project to download dependencies.

## Prerequisites
- Android Studio
- Android SDK
- Kotlin support

## Dependencies
- Jetpack Compose for UI components.
- LiveData and ViewModel for managing UI-related data.
- Retrofit or similar library for network operations (if applicable).

## Key Components
- **MainActivity.kt**: The main entry point of the application, initializing the UI and setting up fragments.
- **WiFiFragment.kt**: Fragment for WiFi network analysis and visualization.
- **MobileDataFragment.kt**: Fragment for mobile data network analysis and visualization.
- **NetworkMonitorService.kt**: Background service for continuous network monitoring.
- **NetworkUtils.kt**: Utility class for network-related operations.
- **Theme.kt**: Defines the application's theme, including styles and attributes for light and dark modes.
- **ThemeUtils.kt**: Utility class to manage light/dark mode switching.
- **ColorScheme.kt**: Contains color definitions used in the app's theme.
- **NetworkUsageCard.kt**: A composable component that displays network usage statistics.
- **NetworkRepository.kt**: Handles data operations related to network monitoring.
- **NetworkViewModel.kt**: Manages UI-related data in a lifecycle-conscious way.
- **AlertManager.kt**: Manages custom alerts and notifications for usage thresholds.
- **ReportGenerator.kt**: Generates usage summaries and reports.
- **SecurityManager.kt**: Handles secure storage and privacy-related operations.

## Usage
Upon launching the app, users can view their current network usage statistics, switch between WiFi and mobile data analysis, and customize their experience with light or dark themes.

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any suggestions or improvements.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Permissions
To function correctly, the app requires the following permissions:
```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
```

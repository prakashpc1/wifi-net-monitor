package com.example.networkmonitor.data

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SecureStorageHelper {

    private const val PREFS_FILE_NAME = "secure_prefs"

    private fun getMasterKey(context: Context): MasterKey {
        return MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
    }

    fun getEncryptedSharedPreferences(context: Context): SharedPreferences {
        return EncryptedSharedPreferences.create(
            context,
            PREFS_FILE_NAME,
            getMasterKey(context),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    // Example usage:
    // fun saveData(context: Context, key: String, value: String) {
    //     val sharedPreferences = getEncryptedSharedPreferences(context)
    //     with(sharedPreferences.edit()) {
    //         putString(key, value)
    //         apply()
    //     }
    // }

    // fun loadData(context: Context, key: String): String? {
    //     val sharedPreferences = getEncryptedSharedPreferences(context)
    //     return sharedPreferences.getString(key, null)
    // }
}
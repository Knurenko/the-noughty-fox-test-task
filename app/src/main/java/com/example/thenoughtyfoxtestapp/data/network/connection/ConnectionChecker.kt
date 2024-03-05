package com.example.thenoughtyfoxtestapp.data.network.connection

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * @author Knurenko Bogdan 05.03.2024
 */
class ConnectionChecker(private val client: OkHttpClient) {
    suspend fun checkInternetConnection(): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val pingGoogle = Request.Builder().url("https://google.com").build()
                client.newCall(pingGoogle).execute()
                true
            } catch (e: Exception) {
                false
            }
        }
    }
}
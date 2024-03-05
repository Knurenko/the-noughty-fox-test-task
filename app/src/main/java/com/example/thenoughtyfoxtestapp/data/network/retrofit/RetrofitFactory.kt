package com.example.thenoughtyfoxtestapp.data.network.retrofit

import com.example.thenoughtyfoxtestapp.data.network.service.CommentService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Knurenko Bogdan 05.03.2024
 */
class RetrofitFactory(private val client: OkHttpClient) {
    private val instance by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createService(): CommentService = instance.create(CommentService::class.java)
}
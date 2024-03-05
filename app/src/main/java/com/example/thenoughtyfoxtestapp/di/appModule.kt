package com.example.thenoughtyfoxtestapp.di

import com.example.thenoughtyfoxtestapp.data.mappers.CommentResponseToModelMapper
import com.example.thenoughtyfoxtestapp.data.network.connection.ConnectionChecker
import com.example.thenoughtyfoxtestapp.data.network.retrofit.RetrofitFactory
import com.example.thenoughtyfoxtestapp.data.network.service.CommentService
import com.example.thenoughtyfoxtestapp.data.repository.CommentRepositoryImpl
import com.example.thenoughtyfoxtestapp.domain.repository.CommentRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module

/**
 * @author Knurenko Bogdan 05.03.2024
 */

val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder().build()
    }

    single<CommentService> {
        RetrofitFactory(
            client = get()
        ).createService()
    }

    single<CommentRepository> {
        CommentRepositoryImpl(
            service = get(),
            connectionChecker = ConnectionChecker(
                client = get()
            ),
            mapper = CommentResponseToModelMapper()
        )
    }
}
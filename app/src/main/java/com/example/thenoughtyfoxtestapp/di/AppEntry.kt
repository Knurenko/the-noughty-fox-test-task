package com.example.thenoughtyfoxtestapp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Knurenko Bogdan 05.03.2024
 */
class AppEntry : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppEntry)
            modules(appModule)
        }
    }
}
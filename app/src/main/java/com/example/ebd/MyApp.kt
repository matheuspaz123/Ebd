package com.example.ebd

import android.app.Application
import com.example.ebd.di.modules.mainViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            AndroidLogger()
            androidContext(this@MyApp)
            modules(mainViewModelModule)
        }

    }
}
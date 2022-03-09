package com.kontick.pluginmanager.core

import android.app.Application
import com.kontick.pluginmanager.di.appModule
import com.kontick.pluginmanager.di.dataModule
import com.kontick.pluginmanager.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PMApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@PMApp)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}
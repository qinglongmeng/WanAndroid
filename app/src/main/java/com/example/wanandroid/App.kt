package com.example.wanandroid

import android.app.Application
import android.content.Context
import com.example.wanandroid.bean.User
import org.koin.android.ext.koin.androidContext

import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

import kotlin.properties.Delegates

/**
 * Author: mql
 * Date: 2023/11/3
 * Describe :
 */
class App : Application() {
    companion object {
        var CONTEXT: Context by Delegates.notNull()
        lateinit var CURRENT_USER: User
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            modules(appModule)
        }
    }
}
package com.example.wanandroid

import android.app.Application
import android.content.Context
import com.example.wanandroid.bean.User
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
}
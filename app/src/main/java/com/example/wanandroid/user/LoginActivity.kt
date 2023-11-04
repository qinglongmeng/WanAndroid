package com.example.wanandroid.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wanandroid.R

/**
 * Author: mql
 * Date: 2023/11/3
 * Describe :
 */
class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
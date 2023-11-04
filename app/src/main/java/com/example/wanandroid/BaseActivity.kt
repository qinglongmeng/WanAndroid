package com.example.wanandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Author: mql
 * Date: 2023/11/4
 * Describe :
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView()
        initData()
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()
}
package com.example.wanandroid

import org.koin.dsl.module

/**
 * Author: mql
 * Date: 2023/11/7
 * Describe :
 */
class KoinModel {
    private val viewModelModule = module {
//        viewModel { FastMainPageViewModel(get(), get()) }
    }

    val appModule = listOf(viewModelModule)
}
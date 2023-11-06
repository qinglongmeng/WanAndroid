package com.example.wanandroid

import com.example.wanandroid.ui.home.table_fragment.model.FastMainPageViewModel
import com.example.wanandroid.ui.home.table_fragment.repo.FastHomeRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Author: mql
 * Date: 2023/11/7
 * Describe :
 */
private val viewModelModule = module {
    viewModel { FastMainPageViewModel(get()) }
}

private val repositoryModule = module {
    single { FastHomeRepository() }
}

val appModule = listOf(viewModelModule, repositoryModule)

/**
 * 除了`viewModel`和`single`，Koin还提供其他一些依赖项管理的方法，例如：

- `factory`：用于定义一个每次都会创建新实例的依赖项。
- `get`：用于手动获取依赖项的实例。
- `bind`：用于将一个实例绑定到另一个类型，使得获取实例的时候可以通过绑定的类型获取
 */
package com.example.wanandroid

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Author: mql
 * Date: 2023/11/5
 * Describe : 父类ViewModel
 */
open class BaseViewModel : ViewModel(){

    /**
     * 处理异步请求对于UI
     */
    fun launchOnUi(block : suspend CoroutineScope.() -> Unit){
        Log.e("BaseViewModel", "launchOnUi")
        viewModelScope.launch { block() }
    }

}
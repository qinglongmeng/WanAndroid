package com.example.wanandroid.bean

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 * Created by luyao
 * on 2018/3/13 14:38
 */
data class WanResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)

suspend fun <T : Any> WanResponse<T>.doSuccess(successBlock: (suspend CoroutineScope.(T) -> Unit)? = null): WanResponse<T> {
    return coroutineScope {
        if (errorCode != -1) successBlock?.invoke(this, this@doSuccess.data)
        this@doSuccess
    }
}

suspend fun <T : Any> WanResponse<T>.doError(errorBlock: (suspend CoroutineScope.(String) -> Unit)? = null): WanResponse<T> {
    return coroutineScope {
        if (errorCode == -1) errorBlock?.invoke(this, this@doError.errorMsg)
        this@doError
    }
}


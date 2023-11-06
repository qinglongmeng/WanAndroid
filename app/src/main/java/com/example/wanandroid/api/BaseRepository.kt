package com.example.wanandroid.api

import com.example.wanandroid.bean.RepoResult
import com.example.wanandroid.bean.WanResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.IOException

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(
        call: suspend () -> RepoResult<T>,
        errorMessage: String
    ): RepoResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            RepoResult.Error(IOException(errorMessage, e))
        }
    }

    suspend fun <T : Any> executeResponse(
        response: WanResponse<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): RepoResult<T> {
        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                RepoResult.Error(IOException(response.errorMsg))
            } else {
                successBlock?.let { it() }
                RepoResult.Success(response.data)
            }
        }
    }
}
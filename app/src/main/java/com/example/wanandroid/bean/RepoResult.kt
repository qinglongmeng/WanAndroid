package com.example.wanandroid.bean

sealed class RepoResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : RepoResult<T>()
    data class Error(val exception: Exception) : RepoResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
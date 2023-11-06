package com.example.wanandroid.user

/**
 * Author: mql
 * Date: 2023/11/5
 * Describe :
 */
open class LoginState<T> (
    val isLoading: Boolean = false,
    val isSuccess: T? = null,
    val isError: String? = null,
    val enableLoginButton: Boolean = true,
    val needLogin: Boolean = false
)
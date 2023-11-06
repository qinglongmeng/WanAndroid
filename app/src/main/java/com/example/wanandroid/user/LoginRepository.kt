package com.example.wanandroid.user

import com.example.wanandroid.App
import com.example.wanandroid.api.WanRetrofitClient
import com.example.wanandroid.bean.User
import com.example.wanandroid.bean.doError
import com.example.wanandroid.bean.doSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

/**
 * Author: mql
 * Date: 2023/11/5
 * Describe :
 */
open class LoginRepository {

    suspend fun loginFlow(userName: String, passWord: String) = flow<LoginState<User>> {
        // 输入不能为空
        if (userName.isBlank() || passWord.isBlank()) {
            emit(LoginState(enableLoginButton = false))
            return@flow
        }

        WanRetrofitClient.service.login(userName, passWord).doSuccess { user ->
            emit(LoginState(isSuccess = user, enableLoginButton = true))
            App.CURRENT_USER = user
        }.doError { errorMsg ->
            emit(LoginState(isError = errorMsg, enableLoginButton = true))
        }
    }.onStart {
        emit(LoginState(isLoading = true))
    }.flowOn(Dispatchers.IO)
        .catch { emit(LoginState(isError = it.message, enableLoginButton = true)) }


    suspend fun registerFlow(userName: String, passWord: String) = flow<LoginState<User>> {
        // 输入不能为空
        if (userName.isBlank() || passWord.isBlank()) {
            emit(LoginState(enableLoginButton = false))
            return@flow
        }

        WanRetrofitClient.service.register(userName, passWord, passWord).doSuccess {
            emit(LoginState(needLogin = true))
        }.doError { errorMsg ->
            emit(LoginState(isError = errorMsg, enableLoginButton = true))
        }
    }.onStart {
        emit(LoginState(isLoading = true))
    }.flowOn(Dispatchers.IO)
        .catch { emit(LoginState(isError = it.message, enableLoginButton = true)) }

}
package com.example.wanandroid.user

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.wanandroid.BaseViewModel
import com.example.wanandroid.bean.User

/**
 * Author: mql
 * Date: 2023/11/4
 * Describe :
 */
class LoginViewModel : BaseViewModel() {
    val userName = ObservableField<String>("")
    val password = ObservableField<String>("")
    val loginStatus = MutableLiveData<LoginState<User>>()

    fun login() {
        launchOnUi {
            LoginRepository().loginFlow(userName.get() ?: "", password.get() ?: "")
                .collect{
                    loginStatus.postValue(it)
                }
        }
    }

    fun register() {
        launchOnUi {
            LoginRepository().registerFlow(userName.get() ?: "", password.get() ?: "")
                .collect{
                    loginStatus.postValue(it)
                }
        }
    }

    private fun isInputValid(userName: String, passWord: String) =
        userName.isNotBlank() && passWord.isNotBlank()

    val verifyInput: (String) -> Unit = {
        //setValue 同步
        loginStatus.value =
            LoginState(enableLoginButton = isInputValid(userName.get() ?: "", password.get() ?: ""))
    }
}
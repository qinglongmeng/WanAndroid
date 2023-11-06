package com.example.wanandroid.user

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.wanandroid.MainActivity
import com.example.wanandroid.R
import com.example.wanandroid.databinding.ActivityLoginBinding
import com.example.wanandroid.util.toast

/**
 * Author: mql
 * Date: 2023/11/3
 * Describe : LoginActivity
 */
const val TAG = "LoginActivity"

class LoginActivity : AppCompatActivity() {
    private val loginViewModel by viewModels<LoginViewModel>()
    private lateinit var dataBinding: ActivityLoginBinding
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        dataBinding.loginViewModel = loginViewModel
        dataBinding.lifecycleOwner = this@LoginActivity
        loginStateObserver()
    }

    private fun loginStateObserver() {
        loginViewModel.apply {
            loginStatus.observe(this@LoginActivity) {
                if (it.isLoading) {
                    Log.e(TAG, "Login_ing")
                    showProgressDialog()
                }
                if (it.needLogin) {
                    Log.e(TAG, "register_Login_ing")
                    dismissProgressDialog()
                    this@LoginActivity.toast("注册成功")
                }
                it.isSuccess?.let {
                    Log.e(TAG, "Login_Success")
                    dismissProgressDialog()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
                it.isError?.let {
                    dismissProgressDialog()
                    Log.e(TAG, it)
                }
            }
        }
    }

    private fun showProgressDialog() {
        if (progressDialog == null)
            progressDialog = ProgressDialog(this@LoginActivity)
        progressDialog?.show()
    }

    private fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }
}
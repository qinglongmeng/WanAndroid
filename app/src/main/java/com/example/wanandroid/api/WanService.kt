package com.example.wanandroid.api

import com.example.wanandroid.bean.ArticleList
import com.example.wanandroid.bean.Banners
import com.example.wanandroid.bean.User
import com.example.wanandroid.bean.WanResponse
import retrofit2.http.*

/**
 * Author: mql
 * Date: 2023/11/5
 * Describe :
 */
interface WanService {
    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    //登陆
    @GET("/user/logout/json")
    suspend fun logOut(): WanResponse<Any>

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): WanResponse<User>

    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(@Field("username") userName: String, @Field("password") passWord: String, @Field("repassword") rePassWord: String): WanResponse<User>


    //首页
    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): WanResponse<ArticleList>

    @GET("/banner/json")
    suspend fun getBanner(): WanResponse<List<Banners>>

    @GET("/user_article/list/{page}/json")
    suspend fun getSquareArticleList(@Path("page") page: Int): WanResponse<ArticleList>
}
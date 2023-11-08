package com.example.wanandroid.ui.home.table_fragment.repo

import com.example.wanandroid.api.BaseRepository
import com.example.wanandroid.api.WanRetrofitClient
import com.example.wanandroid.bean.ArticleList
import com.example.wanandroid.bean.RepoResult
import java.io.IOException

/**
 * Author: mql
 * Date: 2023/11/7
 * Describe :
 */
class SquareRepository : BaseRepository() {

    suspend fun getSquareArticleList(page: Int): RepoResult<ArticleList> {
        return safeApiCall(call = { requestSquareArticleList(page) }, errorMessage = "网络异常")
    }

    private suspend fun requestSquareArticleList(page: Int): RepoResult<ArticleList> {
        val response = WanRetrofitClient.service.getSquareArticleList(page)
        return if (response.errorCode == 0) RepoResult.Success(response.data)
        else RepoResult.Error(IOException(response.errorMsg))
    }
}
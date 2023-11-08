package com.example.wanandroid.ui.home.table_fragment.repo

import com.example.wanandroid.api.BaseRepository
import com.example.wanandroid.api.WanRetrofitClient
import com.example.wanandroid.bean.ArticleList
import com.example.wanandroid.bean.Banners
import com.example.wanandroid.bean.RepoResult

/**
 * Author: mql
 * Date: 2023/11/7
 * Describe :
 */
class FastHomeRepository : BaseRepository() {

    suspend fun getBanners(): RepoResult<List<Banners>> {
        return safeApiCall(call = {requestBanners()},errorMessage = "")
    }

    private suspend fun requestBanners(): RepoResult<List<Banners>> {
        return executeResponse(WanRetrofitClient.service.getBanner())
    }

    suspend fun getArticleList(page: Int): RepoResult<ArticleList> {
        return safeApiCall(call = { requestArticleList(page) }, errorMessage = "")
    }

    private suspend fun requestArticleList(page: Int): RepoResult<ArticleList> =
        executeResponse(WanRetrofitClient.service.getHomeArticles(page))
}
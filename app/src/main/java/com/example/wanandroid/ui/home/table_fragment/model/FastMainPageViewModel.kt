package com.example.wanandroid.ui.home.table_fragment.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.wanandroid.BaseViewModel
import com.example.wanandroid.bean.ArticleList
import com.example.wanandroid.bean.Banners
import com.example.wanandroid.bean.RepoResult
import com.example.wanandroid.ui.home.table_fragment.repo.FastHomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FastMainPageViewModel: BaseViewModel() {

    private val homeRepository: FastHomeRepository = FastHomeRepository()
    private var currentPage = 0
    val status = MutableLiveData<ArticleUiStates>()
    val banner = MutableLiveData<Banners>()

    fun getHomeArticleList(isRefresh: Boolean) {
        viewModelScope.launch(Dispatchers.Main) {
            emitArticleUiState(showLoading = true)
            if (isRefresh) currentPage = 0
            val result = homeRepository.getArticleList(currentPage)
            if (result is RepoResult.Success) {
                val articleList = result.data
                if (articleList.offset >= articleList.total) {
                    emitArticleUiState(showLoading = false, showEnd = true)
                    return@launch
                }
                currentPage++
                emitArticleUiState(
                    showLoading = false,
                    showSuccess = articleList,
                    isRefresh = isRefresh
                )
            } else if (result is RepoResult.Error) {
                emitArticleUiState(showLoading = false, showError = result.exception.message)
            }
        }
    }

    private fun emitArticleUiState(
        showLoading: Boolean = false,
        showError: String? = null,
        showSuccess: ArticleList? = null,
        showEnd: Boolean = false,
        isRefresh: Boolean = false,
        needLogin: Boolean? = null
    ) {
        val uiModel =
            ArticleUiStates(showLoading, showError, showSuccess, showEnd, isRefresh, needLogin)
        status.value = uiModel
    }

    val refreshHome: ()-> Unit = {getHomeArticleList(true)}

    /**
     * 状态
     */
    data class ArticleUiStates(
        val showLoading: Boolean,
        val showError: String?,
        val showSuccess: ArticleList?,
        val showEnd: Boolean, // 加载更多
        val isRefresh: Boolean, // 刷新
        val needLogin: Boolean? = null
    )
}
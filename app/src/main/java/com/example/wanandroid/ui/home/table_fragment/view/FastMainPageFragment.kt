package com.example.wanandroid.ui.home.table_fragment.view

import com.example.wanandroid.BaseVMFragment
import com.example.wanandroid.R
import com.example.wanandroid.databinding.FragmentFastMainPageBinding
import com.example.wanandroid.ui.home.table_fragment.adapter.HomeArticleAdapter
import com.example.wanandroid.ui.home.table_fragment.model.FastMainPageViewModel
import com.example.wanandroid.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class FastMainPageFragment : BaseVMFragment<FragmentFastMainPageBinding>(R.layout.fragment_fast_main_page) {

    private val fastMainViewModel by viewModel<FastMainPageViewModel>()
    private val homeArticleAdapter by lazy { HomeArticleAdapter() }

    override fun initView() {
        dataBinding.apply {
            viewModel = fastMainViewModel
            adapter = homeArticleAdapter
        }
        initRecycleView()
    }

    private fun initRecycleView() {

    }

    override fun initData() {
        refresh()
    }

    private fun loadMore() {
        fastMainViewModel.getHomeArticleList(false)
    }

    override fun startObserve() {
        fastMainViewModel.status.apply {
            observe(viewLifecycleOwner) {
                it.showSuccess?.let { article ->
                    article.datas?.let{ articleList ->
                        homeArticleAdapter.setData(articleList.toMutableList())
                    }
                }

//                if (it.showEnd) adapter.loadMoreEnd()

                it.showError?.let { message ->
                    activity?.toast(if (message.isBlank()) "网络异常" else message)
                }
            }
        }
    }

    private fun refresh() {
        fastMainViewModel.getHomeArticleList(true)
    }
}
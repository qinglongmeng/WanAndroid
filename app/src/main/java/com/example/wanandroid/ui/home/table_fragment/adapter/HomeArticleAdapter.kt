package com.example.wanandroid.ui.home.table_fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroid.R
import com.example.wanandroid.bean.Article
import com.example.wanandroid.databinding.ItemHomeArticeViewBinding

/**
 * Author: mql
 * Date: 2023/11/8
 * Describe :
 */
class HomeArticleAdapter : RecyclerView.Adapter<HomeArticleAdapter.ViewHolder>() {
    private var mArticleDataList: MutableList<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeArticleAdapter.ViewHolder {
        val dataBinding: ItemHomeArticeViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_home_artice_view,
            parent,
            false
        )
        return ViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: HomeArticleAdapter.ViewHolder, position: Int) {
        val articleData = mArticleDataList[position]
        Log.e("HomeArticleAdapter", articleData.id.toString())
        holder.binding.article = articleData
    }

    override fun getItemCount(): Int {
        return if (mArticleDataList.isNotEmpty()) {
            mArticleDataList.size
        } else 0
    }

    fun setData(dataList: MutableList<Article>) {
        mArticleDataList = dataList
        notifyDataSetChanged()
    }

    inner class ViewHolder(dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        var binding: ItemHomeArticeViewBinding
        init {
            binding = dataBinding as ItemHomeArticeViewBinding
        }
    }
}
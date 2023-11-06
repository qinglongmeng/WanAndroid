package com.example.wanandroid.ui.home.table_fragment.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Author: mql
 * Date: 2023/11/8
 * Describe :
 */
class DecorateAdapter(
    private val T: RecyclerView.Adapter<RecyclerView.ViewHolder>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val headerList: MutableList<View> by lazy {
        mutableListOf()
    }

    private val footerList: MutableList<View> by lazy {
        mutableListOf()
    }

    /**创建头部的ViewHolder*/
    private fun createHeaderViewHolder(view: View): RecyclerView.ViewHolder {
        return HeaderViewHolder(view)
    }

    /**创建尾部的ViewHolder*/
    private fun createFooterViewHolder(view: View): RecyclerView.ViewHolder {
        return FooterViewHolder(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        /**头部样式展示*/
        if (headerList.isNotEmpty() && position in 0 until headerList.size) {
            return createHeaderViewHolder(headerList[position])
        }

        /**中间内容展示*/
        val startPosition = if (headerList.isNotEmpty()) headerList.size else 0
        val endPosition =
            if (headerList.isNotEmpty()) headerList.size + T.itemCount else T.itemCount
        if (position in startPosition until endPosition) {
            return T.onCreateViewHolder(parent, position)
        }

        /**尾部样式展示*/
        return createFooterViewHolder(footerList[position - endPosition]) /**注意这里的取值*/
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (headerList.isNotEmpty() && position in 0 until headerList.size) {
            return
        }
        /**中间的内容数据绑定*/
        val startPosition = if (headerList.isNotEmpty()) headerList.size else 0
        val endPosition =
            if (headerList.isNotEmpty()) headerList.size + T.itemCount else T.itemCount
        if (position in startPosition until endPosition) {
            /**注意计算的时候，要减去HeadView*/
            T.onBindViewHolder(holder, position - headerList.size)
        }
    }

    override fun getItemCount(): Int {
        return T.itemCount + headerList.size + footerList.size
    }

    fun addHeaderView(header: View) {
        if (!headerList.contains(header)) {
            headerList.add(header)
            refreshList()
        }
    }

    fun removeHeaderView(header: View) {
        if (headerList.contains(header)) {
            headerList.remove(header)
            refreshList()
        }
    }

    fun addFooterView(foot: View) {
        if (!footerList.contains(foot)) {
            footerList.add(foot)
            refreshList()
        }
    }

    fun removeFooterView(foot: View) {
        if (footerList.contains(foot)) {
            footerList.remove(foot)
            refreshList()
        }
    }

    private fun refreshList() {
        notifyDataSetChanged()
    }

    inner class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    inner class FooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
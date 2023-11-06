package com.example.wanandroid.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.wanandroid.BaseVMFragment
import com.example.wanandroid.R
import com.example.wanandroid.databinding.FragmentHomeBinding
import com.example.wanandroid.ui.home.table_fragment.view.BlankFragment
import com.example.wanandroid.ui.home.table_fragment.view.FastMainPageFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseVMFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val titleList = arrayOf("首页", "广场")
    private var mOnPageChangeCallback: ViewPager2.OnPageChangeCallback? = null

    override fun initView() {
        //绑定ViewPager
        with(dataBinding) {
            homeViewPager.offscreenPageLimit = 1
            homeViewPager.adapter = object : FragmentStateAdapter(this@HomeFragment) {
                override fun getItemCount(): Int {
                    return titleList.size
                }

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> FastMainPageFragment()
                        1 -> BlankFragment()
                        else -> FastMainPageFragment()
                    }
                }
            }

            //绑定tabLayout
            TabLayoutMediator(homeTable, homeViewPager, true, true) { tab, position ->
                tab.text = titleList[position]
            }.attach()
        }
    }

    override fun initData() {
    }

    override fun startObserve() {
    }
}
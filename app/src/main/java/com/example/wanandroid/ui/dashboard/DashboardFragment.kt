package com.example.wanandroid.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.wanandroid.R
import com.example.wanandroid.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var dataBinding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =DataBindingUtil.inflate<FragmentDashboardBinding>(inflater, R.layout.fragment_dashboard, container, false).apply {
            lifecycleOwner = this@DashboardFragment
        }
        return dataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
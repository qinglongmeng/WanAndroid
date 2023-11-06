package com.example.wanandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.wanandroid.R
import com.example.wanandroid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var dataBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_notifications, container, false).apply {
            lifecycleOwner = this@HomeFragment
        }
        return dataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
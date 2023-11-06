package com.example.wanandroid.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.wanandroid.R
import com.example.wanandroid.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {
    private lateinit var dataBinding: FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate<FragmentNotificationsBinding>(inflater, R.layout.fragment_notifications, container, false).apply {
            lifecycleOwner = this@NotificationsFragment
        }
        return dataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
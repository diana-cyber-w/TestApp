package com.example.testapp.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testapp.R
import com.example.testapp.databinding.LoginLayoutBinding
import com.example.testapp.presentation.recycler.LoginAdapter
import com.google.android.material.tabs.TabLayoutMediator

class RegistrationFragment : Fragment(R.layout.login_layout) {

    private val binding: LoginLayoutBinding by viewBinding(LoginLayoutBinding::bind)
    private val adapter by lazy {
        LoginAdapter(
            requireActivity(),
            binding.tabLayout.tabCount
        )
    }
    private val navArgs by navArgs<RegistrationFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> resources.getString(R.string.login)
                1 -> resources.getString(R.string.signup)
                else -> null
            }
        }.attach()

        Handler(Looper.getMainLooper()).postDelayed({
            binding.viewPager.setCurrentItem(navArgs.position.position, false)
        }, 100)
    }
}
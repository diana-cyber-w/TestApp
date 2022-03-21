package com.example.testapp.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testapp.R
import com.example.testapp.databinding.MainFragmentLayoutBinding
import com.example.testapp.presentation.models.ViewPagerPosition

class MainFragment : Fragment(R.layout.main_fragment_layout) {

    private val binding: MainFragmentLayoutBinding by viewBinding(MainFragmentLayoutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            val action = MainFragmentDirections.toRegistration(ViewPagerPosition(0))
            findNavController().navigate(action)

        }
        binding.signupButton.setOnClickListener {
            val action = MainFragmentDirections.toRegistration(ViewPagerPosition(1))
            findNavController().navigate(action)
        }
    }
}
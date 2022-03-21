package com.example.testapp.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testapp.MainApplication
import com.example.testapp.R
import com.example.testapp.databinding.LoginItemLayoutBinding
import com.example.testapp.presentation.viewModels.UserViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.login_item_layout) {

    private val binding: LoginItemLayoutBinding by viewBinding(LoginItemLayoutBinding::bind)

    @Inject
    lateinit var viewModel: UserViewModel

    init {
        MainApplication.appComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAuthUser(
            binding.loginEditText.text.toString().trim(),
            binding.passwordEditText.text.toString().trim()
        )
        binding.signupDone.setOnClickListener {
            if (viewModel.authUser.value?.status == false) {
                showFailedAlertDialog(viewModel.authUser.value?.message.orEmpty())
            } else {
                showSuccessAlertDialog(viewModel.authUser.value?.id.orEmpty())
            }
        }
    }

    private fun showFailedAlertDialog(message: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(message)
            .setPositiveButton(OK) { dialog, which ->
            }
            .show()
    }

    private fun showSuccessAlertDialog(id: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(SUCCESS_MESSAGE + id)
            .setPositiveButton(OK) { dialog, which ->
                findNavController().navigate(R.id.toMain)
            }
            .show()
    }

    companion object {
        private const val SUCCESS_MESSAGE = "«Авторизация успешна. ID — "
        private const val OK = "Ок"
    }
}
package com.example.testapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testapp.MainApplication
import com.example.testapp.R
import com.example.testapp.databinding.SignupItemLayoutBinding
import com.example.testapp.presentation.viewModels.UserViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

class SignupFragment : Fragment(R.layout.signup_item_layout) {

    private val binding: SignupItemLayoutBinding by viewBinding(SignupItemLayoutBinding::bind)

    @Inject
    lateinit var viewModel: UserViewModel

    init {
        MainApplication.appComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.agreeButton.setOnClickListener {
            binding.signupDone.isEnabled = true
            binding.signupDone.alpha = 1F
        }
        binding.signupDone.setOnClickListener {
            viewModel.signupUser(
                binding.nameEditText.text.toString().trim(),
                genderText(),
                binding.birthEditText.text.toString().trim(),
                binding.phoneEditText.text.toString().trim().replace("\\s".toRegex(), ""),
                binding.mailEditText.text.toString().trim(),
                binding.companyEditText.text.toString().trim(),
                binding.serviceEditText.text.toString().trim(),
                binding.loginEditText.text.toString().trim(),
                binding.passwordEditText.text.toString().trim(),
                binding.passwordConfirmEditText.text.toString().trim()
            )
            viewModel.signupUser.observe(viewLifecycleOwner) {
                if (viewModel.signupUser.value?.status == FALSE) {
                    showFailedAlertDialog(viewModel.signupUser.value?.message.orEmpty())
                    viewModel.nullSignup()
                } else if (viewModel.signupUser.value?.status == TRUE) {
                    showSuccessAlertDialog(viewModel.signupUser.value?.userId.orEmpty())
                }
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

    private fun genderText(): String {
        val gender = when (binding.genderButtons.checkedRadioButtonId) {
            R.id.maleButton -> binding.maleButton.text.toString().trim()
            R.id.femaleButton -> binding.femaleButton.text.toString().trim()
            else -> NULL
        }
        return gender
    }

    companion object {
        private const val SUCCESS_MESSAGE = "«Регистрация успешна. ID — "
        private const val OK = "Ок"
        private const val NULL = ""
        private const val TRUE = "TRUE"
        private const val FALSE = "FALSE"
    }
}
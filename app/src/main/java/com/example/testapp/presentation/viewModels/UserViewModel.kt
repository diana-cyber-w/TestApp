package com.example.testapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.interactors.UserInteractor
import com.example.testapp.domain.models.DomainAuthUser
import com.example.testapp.domain.models.DomainSignupUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : ViewModel() {

    val authUser: LiveData<DomainAuthUser> get() = _authUser
    private val _authUser = MutableLiveData<DomainAuthUser>()

    val signupUser: LiveData<DomainSignupUser> get() = _signupUser
    private val _signupUser = MutableLiveData<DomainSignupUser>()

    fun getAuthUser(
        login: String,
        password: String
    ) {
        viewModelScope.launch {
            _authUser.value = userInteractor.getAuthUser(login, password)
        }
    }

    fun signupUser(
        name: String,
        gender: String,
        birthday: String,
        mobile: String,
        email: String,
        workCompany: String,
        ufServiceNumber: String,
        login: String,
        password: String,
        confirmPassword: String
    ) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.Default) {
                val part = async {
                    return@async userInteractor.signupUser(
                        name,
                        gender,
                        birthday,
                        mobile,
                        email,
                        workCompany,
                        ufServiceNumber,
                        login,
                        password,
                        confirmPassword
                    )
                }
                return@withContext part.await()
            }
            _signupUser.value = result
        }
    }

    fun nullSignup() {
        viewModelScope.launch {
            _signupUser.value?.status = ""
        }
    }
}
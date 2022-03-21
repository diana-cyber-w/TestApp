package com.example.testapp.domain.interactors

import com.example.testapp.domain.models.DomainAuthUser
import com.example.testapp.domain.models.DomainSignupUser
import com.example.testapp.domain.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserInteractorImpl @Inject constructor(
    private val networkRepository: NetworkRepository
) : UserInteractor {

    override suspend fun getAuthUser(login: String, password: String): DomainAuthUser {
        return withContext(Dispatchers.IO) {
            networkRepository.getAuthorisedUser(login, password)
        }
    }

    override suspend fun signupUser(
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
    ): DomainSignupUser {
        return withContext(Dispatchers.IO) {
            networkRepository.signupUser(
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
    }
}
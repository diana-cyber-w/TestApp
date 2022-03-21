package com.example.testapp.network.repository

import com.example.testapp.domain.models.DomainAuthUser
import com.example.testapp.domain.models.DomainSignupUser
import com.example.testapp.domain.models.toDomainAuthUser
import com.example.testapp.domain.models.toDomainSignupUser
import com.example.testapp.domain.repository.NetworkRepository
import com.example.testapp.network.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val userApi: UserApi) : NetworkRepository {

    override suspend fun getAuthorisedUser(login: String, password: String): DomainAuthUser {
        return withContext(Dispatchers.IO) {
            userApi.getAuthorisedUser(login, password).toDomainAuthUser()
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
            userApi.registerUser(
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
            ).toDomainSignupUser()
        }
    }
}
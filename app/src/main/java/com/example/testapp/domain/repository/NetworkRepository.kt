package com.example.testapp.domain.repository

import com.example.testapp.domain.models.DomainAuthUser
import com.example.testapp.domain.models.DomainSignupUser

interface NetworkRepository {
    suspend fun getAuthorisedUser(
        login: String,
        password: String
    ): DomainAuthUser

    suspend fun signupUser(
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
    ): DomainSignupUser
}
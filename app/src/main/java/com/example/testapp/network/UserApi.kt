package com.example.testapp.network

import com.example.testapp.network.dto.UserAuthResponse
import com.example.testapp.network.dto.UserRegResponse
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UserApi {
    @Multipart
    @POST("auth.php")
    suspend fun getAuthorisedUser(
        @Part("login") login: String,
        @Part("password") password: String
    ): UserAuthResponse

    @Multipart
    @POST("reg.php")
    suspend fun registerUser(
        @Part("NAME") name: String,
        @Part("PERSONAL_GENDER") personalGender: String,
        @Part("PERSONAL_BIRTHDAY") personalBirthday: String,
        @Part("PERSONAL_MOBILE") personalMobile: String,
        @Part("EMAIL") email: String,
        @Part("WORK_COMPANY") workCompany: String,
        @Part("UF_SERVICE_NUMBER") ufServiceNumber: String,
        @Part("LOGIN") login: String,
        @Part("PASSWORD") password: String,
        @Part("CONFIRM_PASSWORD") confirmPassword: String
    ): UserRegResponse
}
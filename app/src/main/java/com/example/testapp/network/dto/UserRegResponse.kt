package com.example.testapp.network.dto

import com.google.gson.annotations.SerializedName

data class UserRegResponse(
    @SerializedName("USER_ID")
    val userId: String,
    @SerializedName("MESSAGE")
    val message: String,
    @SerializedName("STATUS")
    val status: String
)
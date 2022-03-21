package com.example.testapp.network.dto

import com.google.gson.annotations.SerializedName

data class UserAuthResponse(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("message")
    val message: String
)
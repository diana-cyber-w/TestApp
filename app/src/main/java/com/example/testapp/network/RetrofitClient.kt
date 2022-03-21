package com.example.testapp.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://gg-web.ru/api/"

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun getClient(url: String = BASE_URL) = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getUserApi(): UserApi = getClient().create(UserApi::class.java)
}
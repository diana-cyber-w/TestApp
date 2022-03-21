package com.example.testapp.network.di

import com.example.testapp.domain.repository.NetworkRepository
import com.example.testapp.network.RetrofitClient
import com.example.testapp.network.UserApi
import com.example.testapp.network.repository.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun providesUserApi(): UserApi = RetrofitClient.getUserApi()

    @Provides
    fun providesNetworkRepositoryImpl(
        userApi: UserApi
    ): NetworkRepository =
        NetworkRepositoryImpl(userApi = userApi)
}
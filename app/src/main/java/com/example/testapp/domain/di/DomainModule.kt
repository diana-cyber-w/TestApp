package com.example.testapp.domain.di

import com.example.testapp.domain.interactors.UserInteractor
import com.example.testapp.domain.interactors.UserInteractorImpl
import com.example.testapp.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideUserInteractor(
        networkRepository: NetworkRepository
    ): UserInteractor =
        UserInteractorImpl(networkRepository = networkRepository)
}
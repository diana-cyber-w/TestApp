package com.example.testapp.presentation.di

import com.example.testapp.domain.interactors.UserInteractor
import com.example.testapp.presentation.viewModels.UserViewModel
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun providesUserViewModel(
        userInteractor: UserInteractor
    ): UserViewModel =
        UserViewModel(userInteractor = userInteractor)
}
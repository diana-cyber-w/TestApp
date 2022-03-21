package com.example.testapp

import android.content.Context
import com.example.testapp.domain.di.DomainModule
import com.example.testapp.network.di.NetworkModule
import com.example.testapp.presentation.di.PresentationModule
import com.example.testapp.presentation.fragments.LoginFragment
import com.example.testapp.presentation.fragments.SignupFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(loginFragment: LoginFragment)
    fun inject(signupFragment: SignupFragment)
}
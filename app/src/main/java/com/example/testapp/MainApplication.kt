package com.example.testapp

import android.app.Application

class MainApplication : Application() {

    companion object {
        var appComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
    }

    private fun initDagger(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .bindContext(this@MainApplication)
            .build()
    }
}
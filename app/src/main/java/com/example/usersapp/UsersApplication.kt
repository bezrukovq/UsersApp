package com.example.usersapp

import android.app.Application
import com.example.usersapp.presentation.di.component.AppComponent
import com.example.usersapp.presentation.di.component.DaggerAppComponent

class UsersApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}
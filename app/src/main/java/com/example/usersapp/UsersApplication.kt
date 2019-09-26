package com.example.usersapp

import android.app.Application
import com.example.usersapp.presentation.di.component.AppComponent
import com.example.usersapp.presentation.di.component.DaggerAppComponent
import com.example.usersapp.presentation.di.module.DBModule

class UsersApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().dBModule(DBModule(this)).build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}

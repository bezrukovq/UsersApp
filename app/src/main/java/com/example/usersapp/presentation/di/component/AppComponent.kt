package com.example.usersapp.presentation.di.component

import com.example.usersapp.presentation.di.module.NetModule
import com.example.usersapp.presentation.di.module.ServiceModule
import com.example.usersapp.presentation.di.module.UserModule
import com.example.usersapp.presentation.feature.users_list.UsersListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetModule::class, ServiceModule::class,UserModule::class])
interface AppComponent {
    fun inject(fragment: UsersListFragment)

    fun userComponent(): UserComponent.Builder
}

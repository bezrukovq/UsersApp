package com.example.usersapp.presentation.di.module

import com.example.usersapp.domain.api.UsersApiService
import com.example.usersapp.domain.user.UserCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserModule {

    @Provides
    @Singleton
    fun provideUserCase(usersApiService: UsersApiService): UserCase =
        UserCase(usersApiService)
}

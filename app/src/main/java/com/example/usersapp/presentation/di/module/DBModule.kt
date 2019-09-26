package com.example.usersapp.presentation.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.usersapp.domain.db.AppDB
import com.example.usersapp.domain.db.UserDAO
import com.example.usersapp.domain.db.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideApp(): Context = app

    @Provides
    @Singleton
    fun provideUserDao(appDB: AppDB): UserDAO =
        appDB.userDAO()

    @Provides
    @Singleton
    fun provideDB(app: Context): AppDB = Room.databaseBuilder(app, AppDB::class.java, "database").build()

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDAO) = UserRepository(userDao)
}

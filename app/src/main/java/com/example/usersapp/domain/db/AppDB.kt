package com.example.usersapp.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.usersapp.data.user.User

@Database(entities = [User::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun userDAO() : UserDAO
}

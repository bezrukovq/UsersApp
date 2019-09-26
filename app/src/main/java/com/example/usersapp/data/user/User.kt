package com.example.usersapp.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.usersapp.domain.db.UserConverter
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "user")
@TypeConverters(UserConverter::class)
data class User(
    @PrimaryKey
    var id: Int,
    var guid: String,
    var isActive: Boolean,
    var balance: String,
    var age: Int,
    var eyeColor: String,
    var name: String,
    var gender: String,
    var company: String,
    var email: String,
    var phone: String,
    var address: String,
    var about: String,
    var registered: Date,
    var latitude: Float,
    var longitude: Float,
    var tags: ArrayList<String>,
    var friends: ArrayList<Friend>,
    var favoriteFruit: String
)
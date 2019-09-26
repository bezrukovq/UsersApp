package com.example.usersapp.domain.db

import androidx.room.TypeConverter
import com.example.usersapp.data.user.Friend
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

class UserConverter {
    @TypeConverter
    fun fromDate(date: Date): Long =
        date.time

    @TypeConverter
    fun toDate(date: Long): Date =
        Date(date)

    @TypeConverter
    fun fromTags(tags: ArrayList<String>): String =
        Gson().toJson(tags)

    @TypeConverter
    fun toTags(tags: String): ArrayList<String> =
        Gson().fromJson(tags, object : TypeToken<List<String>>() {}.type)

    @TypeConverter
    fun fromFriends(friends: ArrayList<Friend>): String =
        Gson().toJson(friends)

    @TypeConverter
    fun toFriends(friends: String): ArrayList<Friend> =
        Gson().fromJson(friends, object : TypeToken<List<Friend>>() {}.type)
}

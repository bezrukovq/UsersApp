package com.example.usersapp.data.user

import java.sql.Timestamp

data class User(
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
    var registered: Timestamp,
    var latitude: Long,
    var longitude: Long,
    var tags: ArrayList<String>,
    var friends: ArrayList<Friend>,
    var favouriteFruit: String
)
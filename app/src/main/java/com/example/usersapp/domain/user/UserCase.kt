package com.example.usersapp.domain.user

import com.example.usersapp.data.user.User
import com.example.usersapp.domain.api.UsersApiService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers


class UserCase(val usersApiService: UsersApiService) {

    var users = ArrayList<User>()

    fun saveUsersToDB(it: List<User>) {
        users = it as ArrayList<User>
    }

    fun getUsersFromNet(): Single<List<User>> =
        usersApiService.getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getUsersFromDB(){}
}

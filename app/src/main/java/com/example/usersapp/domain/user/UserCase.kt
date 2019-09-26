package com.example.usersapp.domain.user

import android.annotation.SuppressLint
import com.example.usersapp.data.user.User
import com.example.usersapp.domain.api.UsersApiService
import com.example.usersapp.domain.db.UserRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy


class UserCase(private val usersApiService: UsersApiService, private val userRepository: UserRepository) {

    @SuppressLint("CheckResult")
    fun saveUsersToDB(users: List<User>) {
        userRepository.deleteAll()
            .subscribeBy(
                onComplete = { userRepository.insertUsers(users) },
                onError = {})
    }

    fun getUsersFromNet(): Single<List<User>> =
        usersApiService.getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getUsersFromDB(): Single<List<User>> =
        userRepository.getUsers()

    fun getUserById(id:Int): Single<User> =
        userRepository.getUserById(id)
}

package com.example.usersapp.domain.db

import com.example.usersapp.data.user.User
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserRepository(val userDAO: UserDAO) {

    fun deleteAll() =
        Completable.fromAction { userDAO.deleteAll() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getUsers(): Single<List<User>> =
        userDAO.getUsersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun insertUsers(usersList: List<User>) =
        Completable.fromAction { userDAO.insertUsers(usersList) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe()
}

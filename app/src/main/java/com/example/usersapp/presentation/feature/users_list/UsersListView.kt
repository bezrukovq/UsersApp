package com.example.usersapp.presentation.feature.users_list

import com.arellomobile.mvp.MvpView
import com.example.usersapp.data.user.User

interface UsersListView: MvpView {
    fun setList(list: List<User>)
}
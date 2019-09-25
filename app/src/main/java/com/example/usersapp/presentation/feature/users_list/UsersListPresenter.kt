package com.example.usersapp.presentation.feature.users_list

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.usersapp.domain.user.UserCase
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class UsersListPresenter
    @Inject constructor(val userCase: UserCase): MvpPresenter<UsersListView>() {
    override fun onFirstViewAttach() {
        val disposable = userCase.getUsersFromNet().subscribeBy(
            onSuccess = {
            viewState.setList(it)
        },
            onError = {
                Log.i("ERROR LOADING",it.message!!)
            })
    }
}
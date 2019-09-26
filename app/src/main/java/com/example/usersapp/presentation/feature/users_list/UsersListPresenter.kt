package com.example.usersapp.presentation.feature.users_list

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.usersapp.domain.user.UserCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class UsersListPresenter
@Inject constructor(private val userCase: UserCase) : MvpPresenter<UsersListView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        loadFromDB()
    }

    fun loadFromNet() {
        val disposable = userCase.getUsersFromNet().subscribeBy(
            onSuccess = {
                viewState.setList(it)
                userCase.saveUsersToDB(it)
            },
            onError = {
                Log.i("ERROR LOADING", it.message.toString())
                viewState.showError(it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    private fun loadFromDB() {
        val disposable = userCase.getUsersFromDB().subscribeBy(
            onSuccess = {
                if (it.isNotEmpty())
                    viewState.setList(it)
                else{
                    viewState.showError("No cached data")
                }
            },
            onError = {
                viewState.showError(it.message.toString())
                loadFromNet()
            }
        )
        compositeDisposable.add(disposable)
    }

    override fun destroyView(view: UsersListView?) {
        super.destroyView(view)
        compositeDisposable.clear()
    }
}
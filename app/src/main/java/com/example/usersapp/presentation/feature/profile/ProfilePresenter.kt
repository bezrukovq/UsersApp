package com.example.usersapp.presentation.feature.profile

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.usersapp.data.user.User
import com.example.usersapp.domain.user.UserCase
import io.reactivex.rxkotlin.subscribeBy
import java.text.SimpleDateFormat
import javax.inject.Inject

@InjectViewState
class ProfilePresenter
@Inject constructor(private val userCase: UserCase) : MvpPresenter<ProfileView>() {

    fun openProfile(id: Int) {
        if (id != -1)
            userCase.getUserById(id).subscribeBy(
                onSuccess = {
                    setUser(it)
                },
                onError = {
                    viewState.showError(it.message.toString())
                }
            )
        else
            viewState.showError("Error, no such user")
    }

    @SuppressLint("SimpleDateFormat")
    private fun setUser(it:User){
        viewState.setName(it.name)
        viewState.setAge(it.age)
        viewState.setCompany(it.company)
        viewState.setEmail(it.email)
        viewState.setPhone(it.phone)
        viewState.setEyeColor(it.eyeColor)
        viewState.setFavoriteFruit(it.favoriteFruit)
        viewState.setAbout(it.about)
        val registered = SimpleDateFormat("HH:mm dd.MM.yy").format(it.registered)
        viewState.setRegistered(registered)
        viewState.setAddress(it.address)
        viewState.setLocation(it.latitude,it.longitude)
        val friends = arrayListOf<User>()
        for (f in it.friends)
            userCase.getUserById(f.id).subscribeBy(
                onSuccess = {
                    friends.add(it)
                    viewState.setFriends(friends)
                },
                onError = {
                    viewState.showError(it.message.toString())
                }
            )

    }
}

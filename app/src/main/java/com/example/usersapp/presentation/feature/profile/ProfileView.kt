package com.example.usersapp.presentation.feature.profile

import com.arellomobile.mvp.MvpView
import com.example.usersapp.data.user.User
import java.util.ArrayList

interface ProfileView : MvpView {
    fun setName(name: String)
    fun setAge(age: Int)
    fun setCompany(company: String)
    fun setEmail(email: String)
    fun setPhone(phone: String)
    fun setEyeColor(eyeColor: String)
    fun setFavoriteFruit(favoriteFruit: String)
    fun setAbout(about: String)
    fun setAddress(address: String)
    fun setLocation(latitude: Float, longitude: Float)
    fun showError(error: String)
    fun setFriends(friends: ArrayList<User>)
    fun setRegistered(registered: String)
}

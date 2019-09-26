package com.example.usersapp.domain.api

import com.example.usersapp.data.user.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface UsersApiService {
    @Headers("Content-Type: application/json")
    @GET("users.json")
    fun getUsers(): Single<List<User>>
}

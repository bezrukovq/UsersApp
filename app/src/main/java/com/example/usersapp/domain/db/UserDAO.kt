package com.example.usersapp.domain.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.usersapp.data.user.User
import io.reactivex.Single

@Dao
interface UserDAO {

    @Query("select * from user")
    fun getUsersList(): Single<List<User>>

    @Query("select * from user where id =(:id)")
    fun getUserById(id:Int): Single<User>

    @Insert
    fun insertUsers(city: List<User>)

    @Query("delete from user")
    fun deleteAll()
}

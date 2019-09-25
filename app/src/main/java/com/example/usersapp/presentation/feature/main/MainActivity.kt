package com.example.usersapp.presentation.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usersapp.R
import com.example.usersapp.presentation.feature.users_list.UsersListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, UsersListFragment())
            .commit()
    }
}

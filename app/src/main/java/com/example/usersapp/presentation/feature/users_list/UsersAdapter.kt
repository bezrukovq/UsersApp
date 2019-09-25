package com.example.usersapp.presentation.feature.users_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.R
import com.example.usersapp.data.user.User

class UsersAdapter(val onClick : (Int) -> Unit) : RecyclerView.Adapter<UsersHolder>() {
    var users: List<User> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false)
        return UsersHolder(v)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UsersHolder, position: Int) =
        holder.bind(users[position],onClick)
}

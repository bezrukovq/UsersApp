package com.example.usersapp.presentation.feature.users_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.R
import com.example.usersapp.data.user.User
import kotlinx.android.synthetic.main.users_list_item.view.*

class UsersHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: User) {
        itemView.tv_name.text = user.name
        itemView.tv_email.text = user.email
        if (user.isActive)
            itemView.active.setImageResource(R.drawable.ic_active_true_24dp)
        else
            itemView.active.setImageResource(R.drawable.ic_active_false_24dp)


    }
}

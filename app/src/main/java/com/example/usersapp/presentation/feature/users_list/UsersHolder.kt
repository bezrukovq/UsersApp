package com.example.usersapp.presentation.feature.users_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.R
import com.example.usersapp.data.user.User
import kotlinx.android.synthetic.main.users_list_item.view.*

class UsersHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: User, onClick: (Int) -> Unit) {
        itemView.tv_name.text = user.name
        itemView.tv_email.text = user.registered.toString()
        if (user.isActive) {
            itemView.active.setImageResource(R.drawable.ic_active_true_24dp)
            itemView.setOnClickListener { onClick(user.id) }
        } else {
            itemView.active.setImageResource(R.drawable.ic_active_false_24dp)
            itemView.isClickable = false
        }
    }
}

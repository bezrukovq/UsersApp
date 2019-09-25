package com.example.usersapp.presentation.feature.users_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.usersapp.R
import com.example.usersapp.UsersApplication
import com.example.usersapp.data.user.User
import javax.inject.Inject

class UsersListFragment : MvpAppCompatFragment(), SwipeRefreshLayout.OnRefreshListener, UsersListView {

    private var adapter: UsersAdapter = UsersAdapter()

    @Inject
    @InjectPresenter
    lateinit var presenter: UsersListPresenter

    @ProvidePresenter
    fun initPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        UsersApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_users_list, container, false)

    override fun onRefresh() {}

    override fun setList(list: List<User>) {
        adapter.users = list
        adapter.notifyDataSetChanged()
    }
}
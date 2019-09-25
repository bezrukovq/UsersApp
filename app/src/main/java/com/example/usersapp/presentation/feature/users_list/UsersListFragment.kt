package com.example.usersapp.presentation.feature.users_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.usersapp.R
import com.example.usersapp.UsersApplication
import com.example.usersapp.data.user.User
import kotlinx.android.synthetic.main.fragment_users_list.*
import javax.inject.Inject

class UsersListFragment : MvpAppCompatFragment(), SwipeRefreshLayout.OnRefreshListener, UsersListView {

    private var adapter: UsersAdapter = UsersAdapter { x -> openUser(x) }

    @Inject
    @InjectPresenter
    lateinit var presenter: UsersListPresenter

    @ProvidePresenter
    fun initPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        UsersApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_users_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_users_list.adapter = adapter
        rv_users_list.addItemDecoration(
            DividerItemDecoration(
                rv_users_list.context,
                DividerItemDecoration.VERTICAL
            )
        )
        swipe_refresh.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        swipe_refresh.isRefreshing = true
        presenter.loadFromNet()
    }

    override fun setList(list: List<User>) {
        adapter.users = list
        adapter.notifyDataSetChanged()
        swipe_refresh.isRefreshing = false
    }

    override fun showError(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

    private fun openUser(id: Int) {
        Toast.makeText(activity, id.toString(), Toast.LENGTH_LONG).show()
    }
}
package com.example.usersapp.presentation.feature.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.usersapp.R
import com.example.usersapp.UsersApplication
import com.example.usersapp.data.user.User
import com.example.usersapp.presentation.feature.users_list.UsersAdapter
import kotlinx.android.synthetic.main.fragment_profile.*
import java.util.*
import javax.inject.Inject


class ProfileFragment : MvpAppCompatFragment(), ProfileView {

    private var adapter: UsersAdapter = UsersAdapter { x -> openUser(x) }

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun initPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        UsersApplication.appComponent.userComponent().build().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_users_list.adapter = adapter
        rv_users_list.addItemDecoration(
            DividerItemDecoration(
                rv_users_list.context,
                DividerItemDecoration.VERTICAL
            )
        )
        val id = arguments?.getInt("user", -1) ?: -1
        presenter.openProfile(id)
    }

    override fun setFriends(friends: ArrayList<User>) {
        adapter.users = friends
        adapter.notifyDataSetChanged()
    }

    private fun openUser(id: Int) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, newInstance(id))
            ?.addToBackStack(null)
            ?.commit()
    }

    override fun setName(name: String) {
        tv_profile_name.text = name
    }

    override fun setAbout(about: String) {
        tv_profile_about.text = about
    }

    override fun setAddress(address: String) {
        tv_profile_address.text = address
    }

    override fun setAge(age: Int) {
        tv_profile_age.text = age.toString()
    }

    override fun setCompany(company: String) {
        tv_profile_company.text = company
    }

    override fun setRegistered(registered: String) {
        tv_profile_registered.text = registered
    }

    override fun setEyeColor(eyeColor: String) {
        when (eyeColor) {
            "blue" -> profile_eye_ic.setImageResource(R.drawable.ic_eye_blue_24dp)
            "green" -> profile_eye_ic.setImageResource(R.drawable.ic_eye_green_24dp)
            "brown" -> profile_eye_ic.setImageResource(R.drawable.ic_eye_brown_24dp)
        }
        tv_profile_eye.text = eyeColor
    }

    override fun setFavoriteFruit(favoriteFruit: String) {
        tv_profile_fruit.text = favoriteFruit
        when (favoriteFruit) {
            "banana" -> profile_fruit_ic.setImageResource(R.drawable.banana)
            "apple" -> profile_fruit_ic.setImageResource(R.drawable.apple)
            "strawberry" -> profile_fruit_ic.setImageResource(R.drawable.strawberry)
        }
    }

    override fun setEmail(email: String) {
        tv_profile_email.text = email
        email_view.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:$email"))
            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }

    override fun setPhone(phone: String) {
        tv_profile_phone.text = phone
        phone_view.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            startActivity(Intent.createChooser(intent, "Call"))
        }
    }

    override fun setLocation(latitude: Float, longitude: Float) {
        val location = "$latitude, $longitude"
        tv_profile_location.text = location
        location_view.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:$latitude,$longitude"))
            startActivity(intent)
        }
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }

    companion object {

        private const val ARG_USER = "user"

        fun newInstance(id: Int): ProfileFragment {
            val fragment = ProfileFragment()
            val args = Bundle()
            args.putInt(ARG_USER, id)
            fragment.arguments = args
            return fragment
        }
    }
}
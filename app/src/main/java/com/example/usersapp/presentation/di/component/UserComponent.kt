package com.example.usersapp.presentation.di.component

import com.example.usersapp.presentation.di.scope.UserScope
import com.example.usersapp.presentation.feature.profile.ProfileFragment
import dagger.Subcomponent

@UserScope
@Subcomponent
interface UserComponent {

    fun inject(myProfileFragment: ProfileFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserComponent
    }
}

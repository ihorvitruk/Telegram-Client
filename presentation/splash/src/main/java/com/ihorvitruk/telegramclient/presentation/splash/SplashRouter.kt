package com.ihorvitruk.telegramclient.presentation.splash

import android.app.Activity
import com.ihorvitruk.telegramclient.presentation.base.BaseRouter
import javax.inject.Inject

class SplashRouter @Inject constructor(activity: Activity) : BaseRouter(activity) {

    fun onAuthorizationChecked(isLoggedIn: Boolean) {
        when (isLoggedIn) {
            true -> showChatList()
            false -> showLoginPhone()
        }
    }

    private fun showLoginPhone() {
    }

    private fun showChatList() {
    }
}

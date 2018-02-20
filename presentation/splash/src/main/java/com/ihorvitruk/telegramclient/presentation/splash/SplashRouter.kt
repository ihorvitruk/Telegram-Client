package com.ihorvitruk.telegramclient.presentation.splash

import com.ihorvitruk.telegramclient.presentation.base.BaseActivity
import com.ihorvitruk.telegramclient.presentation.base.BaseRouter
import javax.inject.Inject

class SplashRouter @Inject constructor(activity: BaseActivity) : BaseRouter(activity) {

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

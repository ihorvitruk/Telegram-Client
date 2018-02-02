package com.ihorvitruk.telegramclient.app.activity

import android.content.Intent
import com.ihorvitruk.telegramclient.presentation.splash.SplashRouter

class SplashActivity : BaseActivity() {

    private val splashRouter = object : SplashRouter() {
        override fun onAuthorizationChecked(isLoggedIn: Boolean) {
            when (isLoggedIn) {
                true -> showChatList()
                false -> showLoginPhone()
            }
        }
    }

    private fun showLoginPhone() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun showChatList() {
        startActivity(Intent())
    }
}
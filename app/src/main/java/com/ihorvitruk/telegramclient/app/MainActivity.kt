package com.ihorvitruk.telegramclient.app

import android.os.Bundle
import com.ihorvitruk.telegramclient.data.repository.ValueRepository
import com.ihorvitruk.telegramclient.domain.interactor.SplashInteractor
import com.ihorvitruk.telegramclient.presentation.chat.list.ChatListView
import com.ihorvitruk.telegramclient.presentation.chat.list.ChatListViewModel
import com.ihorvitruk.telegramclient.presentation.login.phone.LoginPhoneView
import com.ihorvitruk.telegramclient.presentation.login.phone.LoginPhoneViewModel
import com.ihorvitruk.telegramclient.presentation.splash.SplashRouter
import com.ihorvitruk.telegramclient.presentation.splash.SplashView
import com.ihorvitruk.telegramclient.presentation.splash.SplashViewModel

class MainActivity : BaseActivity() {

    private val splashViewModel = SplashViewModel(SplashInteractor(ValueRepository()))

    private val loginPhoneViewModel = LoginPhoneViewModel()

    private val chatListViewModel = ChatListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showSplash()
    }

    private val splashRouter = object : SplashRouter() {
        override fun onAuthorizationChecked(isLoggedIn: Boolean) {
            when (isLoggedIn) {
                true -> showChatList()
                false -> showLoginPhone()
            }
        }
    }
    
    private fun showSplash() {
        val splashView = SplashView(this, splashViewModel)
        splashViewModel.router = splashRouter
        replaceView(splashView, splashViewModel)
    }

    private fun showLoginPhone() {
        val loginPhoneView = LoginPhoneView(this, loginPhoneViewModel)
        replaceView(loginPhoneView, loginPhoneViewModel)
    }

    private fun showChatList() {
        val chatListView = ChatListView(this, chatListViewModel)
        replaceView(chatListView, chatListViewModel)
    }
}
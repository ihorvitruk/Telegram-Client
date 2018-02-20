package com.ihorvitruk.telegramclient.app.activity

import android.os.Bundle
import com.ihorvitruk.telegramclient.presentation.base.BaseActivity
import com.ihorvitruk.telegramclient.presentation.splash.SplashViewModel
import javax.inject.Inject

class SingleActivity : BaseActivity() {

    /* private lateinit var splashViewModel: SplashViewModel

     private val loginPhoneViewModel = LoginPhoneViewModel()

     private val chatListViewModel = ChatListViewModel()*/

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showSplash()
    }

    private fun showSplash() {
        splashViewModel.onCreate()
        /*val splashView = SplashView(this, splashViewModel)
        splashViewModel.router = splashRouter
        replaceView(splashView, splashViewModel)*/
    }

    private fun showLoginPhone() {
       /* val loginPhoneView = LoginPhoneView(this, loginPhoneViewModel)
        replaceView(loginPhoneView, loginPhoneViewModel)*/
    }

    private fun showChatList() {
       /* val chatListView = ChatListView(this, chatListViewModel)
        replaceView(chatListView, chatListViewModel)*/
    }
}
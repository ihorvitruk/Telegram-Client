package com.ihorvitruk.telegramclient.app.activity

import android.os.Bundle
import com.ihorvitruk.telegramclient.data.repository.EncryptionRepository
import com.ihorvitruk.telegramclient.data.repository.EncryptionKeyRepository
import com.ihorvitruk.telegramclient.data.repository.NetworkRepository
import com.ihorvitruk.telegramclient.data.repository.KeyValueRepository
import com.ihorvitruk.telegramclient.domain.interactor.CredentialsInteractor
import com.ihorvitruk.telegramclient.domain.interactor.NetworkInteractor
import com.ihorvitruk.telegramclient.presentation.chat.list.ChatListView
import com.ihorvitruk.telegramclient.presentation.chat.list.ChatListViewModel
import com.ihorvitruk.telegramclient.presentation.login.phone.LoginPhoneView
import com.ihorvitruk.telegramclient.presentation.login.phone.LoginPhoneViewModel
import com.ihorvitruk.telegramclient.presentation.splash.SplashRouter
import com.ihorvitruk.telegramclient.presentation.splash.SplashView
import com.ihorvitruk.telegramclient.presentation.splash.SplashViewModel

class ChatActivity : BaseActivity() {

   /* private lateinit var splashViewModel: SplashViewModel

    private val loginPhoneViewModel = LoginPhoneViewModel()

    private val chatListViewModel = ChatListViewModel()*/

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel = SplashViewModel(
                CredentialsInteractor(
                        KeyValueRepository(this),
                        EncryptionKeyRepository(this),
                        EncryptionRepository()
                ),
                NetworkInteractor(
                        NetworkRepository(this)
                )
        )
        showSplash()
    }*/

    /*private val splashRouter = object : SplashRouter() {
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
    }*/
}
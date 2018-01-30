package com.ihorvitruk.telegramclient.presentation.splash

import com.ihorvitruk.telegramclient.presentation.base.BaseRouter

abstract class SplashRouter: BaseRouter() {

    abstract fun onAuthorizationChecked(isLoggedIn: Boolean)
}
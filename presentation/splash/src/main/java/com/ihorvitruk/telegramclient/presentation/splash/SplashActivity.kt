package com.ihorvitruk.telegramclient.presentation.splash

import android.os.Bundle
import com.ihorvitruk.telegramclient.presentation.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashViewModel = SplashViewModel()

        val splashView = SplashView(this, splashViewModel)
        setContentView(splashView)

        splashViewModel.onCreate()
    }
}

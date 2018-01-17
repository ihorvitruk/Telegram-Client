package com.ihorvitruk.telegramclient.splash

import android.os.Bundle
import com.ihorvitruk.telegramclient.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashViewModel = SplashViewModel()

        val splashView = SplashView(this, splashViewModel)
        setContentView(splashView)

        splashViewModel.onCreate()
    }
}

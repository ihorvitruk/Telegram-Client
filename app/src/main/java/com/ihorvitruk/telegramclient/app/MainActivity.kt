package com.ihorvitruk.telegramclient.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ihorvitruk.telegramclient.presentation.splash.SplashView
import com.ihorvitruk.telegramclient.presentation.splash.SplashViewModel

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashViewModel = SplashViewModel()

        val splashView = SplashView(this, splashViewModel)
        setContentView(splashView)

        splashViewModel.onCreate()
    }
}
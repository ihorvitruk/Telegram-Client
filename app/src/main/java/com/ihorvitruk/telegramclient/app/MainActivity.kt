package com.ihorvitruk.telegramclient.app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ihorvitruk.telegramclient.data.repository.AccountRepository
import com.ihorvitruk.telegramclient.domain.interactor.SplashInteractor
import com.ihorvitruk.telegramclient.presentation.base.BaseActivity
import com.ihorvitruk.telegramclient.presentation.base.UI
import com.ihorvitruk.telegramclient.presentation.splash.SplashView
import com.ihorvitruk.telegramclient.presentation.splash.SplashViewModel
import kotlinx.coroutines.experimental.async

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashViewModel = SplashViewModel(SplashInteractor(AccountRepository()))

        val splashView = SplashView(this, splashViewModel)
        setContentView(splashView)

        splashViewModel.onCreate()

        /*SomeRepository(this).doSmthg()*/

        splashViewModel.loadData()
    }


}
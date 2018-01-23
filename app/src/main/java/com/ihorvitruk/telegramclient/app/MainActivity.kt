package com.ihorvitruk.telegramclient.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ihorvitruk.telegramclient.data.repository.AccountRepository
import com.ihorvitruk.telegramclient.presentation.splash.SplashView
import com.ihorvitruk.telegramclient.presentation.splash.SplashViewModel
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashViewModel = SplashViewModel()

        val splashView = SplashView(this, splashViewModel)
        setContentView(splashView)

        splashViewModel.onCreate()

        /*SomeRepository(this).doSmthg()*/

        loadData()
    }

    private fun loadData() {
        launch {
            val account = AccountRepository().readAccount().await()
            Log.d("OBJ", account.toString())
        }
        Log.d("OBJ", "Hello 2")
    }
}
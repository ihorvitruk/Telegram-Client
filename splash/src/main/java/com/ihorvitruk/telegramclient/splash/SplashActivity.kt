package com.ihorvitruk.telegramclient.splash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ihorvitruk.telegramclient.splash.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashViewModel = SplashViewModel()
        val binding = DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
        binding?.viewModel = splashViewModel
        binding?.setLifecycleOwner(this)

        splashViewModel.onCreate()
    }
}

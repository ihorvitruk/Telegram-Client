package com.ihorvitruk.telegramclient.splash

import android.arch.lifecycle.MutableLiveData
import com.ihorvitruk.telegramclient.base.BaseViewModel

class SplashViewModel : BaseViewModel() {

    val title = MutableLiveData<String>()

    override fun onCreate() {
        super.onCreate()
        title.postValue("Hello 2")
    }
}


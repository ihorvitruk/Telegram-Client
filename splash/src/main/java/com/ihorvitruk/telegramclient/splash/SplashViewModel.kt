package com.ihorvitruk.telegramclient.splash

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    val title = MutableLiveData<String>()

    fun onCreate() = title.postValue("Hello")
}


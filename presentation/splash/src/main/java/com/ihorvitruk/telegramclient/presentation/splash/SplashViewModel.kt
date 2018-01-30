package com.ihorvitruk.telegramclient.presentation.splash

import android.arch.lifecycle.MutableLiveData
import com.ihorvitruk.telegramclient.domain.interactor.SplashInteractor
import com.ihorvitruk.telegramclient.domain.repository.IAccountRepository
import com.ihorvitruk.telegramclient.presentation.base.BaseViewModel

class SplashViewModel(private val splashInteractor: SplashInteractor) : BaseViewModel() {

    val title = MutableLiveData<String>()

    override fun onCreate() {
        super.onCreate()
        title.postValue("Hello 2")
    }

    fun loadData() {
        execute(splashInteractor.isUserLoggedIn(),
                { errorText.postValue(it.toString()) },
                { errorText.postValue(it.toString()) }
        )
    }
}


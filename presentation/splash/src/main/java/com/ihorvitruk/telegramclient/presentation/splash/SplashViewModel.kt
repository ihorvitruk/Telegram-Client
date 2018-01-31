package com.ihorvitruk.telegramclient.presentation.splash

import android.arch.lifecycle.MutableLiveData
import com.ihorvitruk.telegramclient.domain.interactor.SplashInteractor
import com.ihorvitruk.telegramclient.presentation.base.BaseViewModel

class SplashViewModel(private val splashInteractor: SplashInteractor) : BaseViewModel<SplashRouter>() {

    val title = MutableLiveData<String>()

    override fun onCreate() {
        super.onCreate()
        title.postValue("Hello 2")

        checkAuthorization()
    }

    private fun checkAuthorization() {
        execute(splashInteractor.isUserLoggedIn(),
                { router?.onAuthorizationChecked(it) },
                { errorText.postValue(it.toString()) }
        )
    }
}


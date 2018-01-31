package com.ihorvitruk.telegramclient.presentation.splash

import android.arch.lifecycle.MutableLiveData
import com.ihorvitruk.telegramclient.domain.interactor.NetworkInteractor
import com.ihorvitruk.telegramclient.domain.interactor.SplashInteractor
import com.ihorvitruk.telegramclient.presentation.base.BaseViewModel

class SplashViewModel(private val splashInteractor: SplashInteractor,
                      private val networkInteractor: NetworkInteractor
) : BaseViewModel<SplashRouter>() {

    val title = MutableLiveData<String>()

    override fun onCreate() {
        super.onCreate()
        checkNetworkConnection()
    }

    private fun checkNetworkConnection() {
        execute(networkInteractor.checkNetworkConnection(),
                { checkAuthorization() },
                { handleError(it) })
    }

    private fun checkAuthorization() {
        execute(splashInteractor.isUserLoggedIn(),
                { router?.onAuthorizationChecked(it) },
                { errorText.postValue(it.toString()) }
        )
    }
}


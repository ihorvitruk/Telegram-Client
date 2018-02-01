package com.ihorvitruk.telegramclient.presentation.splash

import android.arch.lifecycle.MutableLiveData
import com.ihorvitruk.telegramclient.domain.interactor.CredentialsInteractor
import com.ihorvitruk.telegramclient.domain.interactor.NetworkInteractor
import com.ihorvitruk.telegramclient.presentation.base.BaseViewModel

class SplashViewModel(
        private val credentialsInteractor: CredentialsInteractor,
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
        execute(credentialsInteractor.readApiId(),
                {
                    val isLoggedIn = it != null
                    router?.onAuthorizationChecked(isLoggedIn)
                },
                {
                    errorText.postValue(it.toString())
                }
        )
    }
}


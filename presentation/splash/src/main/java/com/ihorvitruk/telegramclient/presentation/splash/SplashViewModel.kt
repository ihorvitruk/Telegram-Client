package com.ihorvitruk.telegramclient.presentation.splash

import android.arch.lifecycle.MutableLiveData
import com.ihorvitruk.telegramclient.domain.interactor.CredentialsInteractor
import com.ihorvitruk.telegramclient.domain.interactor.NetworkInteractor
import com.ihorvitruk.telegramclient.presentation.base.BaseViewModel
import com.ihorvitruk.telegramclient.presentation.base.UI
import kotlinx.coroutines.experimental.async

class SplashViewModel(
        private val credentialsInteractor: CredentialsInteractor,
        private val networkInteractor: NetworkInteractor
) : BaseViewModel<SplashRouter>() {

    val title = MutableLiveData<String>()

    override fun onCreate() {
        super.onCreate()
        async(UI) {
            credentialsInteractor.writeApiId("45678").await()
            val apiId = credentialsInteractor.readApiId().await()
            handleError(Throwable(apiId))
        }
        //checkNetworkConnection()
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
                { handleError(it) }
        )
    }
}


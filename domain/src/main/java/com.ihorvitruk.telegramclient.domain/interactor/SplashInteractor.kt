package com.ihorvitruk.telegramclient.domain.interactor

import com.ihorvitruk.telegramclient.domain.repository.IAccountRepository
import kotlinx.coroutines.experimental.async

class SplashInteractor(private val accountRepository: IAccountRepository) {

    fun isUserLoggedIn() = async {
        accountRepository.readAccount().await().apiId != null
    }
}
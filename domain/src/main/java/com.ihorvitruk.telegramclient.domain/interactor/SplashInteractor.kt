package com.ihorvitruk.telegramclient.domain.interactor

import com.ihorvitruk.telegramclient.domain.repository.IValueRepository
import kotlinx.coroutines.experimental.async

class SplashInteractor(private val valueRepository: IValueRepository) {

    fun isUserLoggedIn() = async {
        valueRepository.read().await().apiId != null
    }
}
package com.ihorvitruk.telegramclient.domain.interactor

import com.ihorvitruk.telegramclient.domain.repository.INetworkRepository

class NetworkInteractor(private val networkRepository: INetworkRepository) {

    fun checkNetworkConnection() = networkRepository.checkNetworkConnection()
}
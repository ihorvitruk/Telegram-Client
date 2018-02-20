package com.ihorvitruk.telegramclient.domain.interactor

import com.ihorvitruk.telegramclient.domain.repository.INetworkRepository
import javax.inject.Inject

class NetworkInteractor @Inject constructor(private val networkRepository: INetworkRepository) {

    fun checkNetworkConnection() = networkRepository.checkNetworkConnection()
}
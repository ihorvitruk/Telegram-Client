package com.ihorvitruk.telegramclient.data.repository

import com.ihorvitruk.telegramclient.domain.repository.INetworkRepository

class NetworkRepository: INetworkRepository {
    override fun isNetworkAvailable() = true
}
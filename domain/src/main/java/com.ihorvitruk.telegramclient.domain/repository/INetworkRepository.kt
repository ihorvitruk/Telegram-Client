package com.ihorvitruk.telegramclient.domain.repository

interface INetworkRepository {

    fun isNetworkAvailable(): Boolean
}
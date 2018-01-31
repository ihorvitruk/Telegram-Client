package com.ihorvitruk.telegramclient.data.repository

import android.content.Context
import android.net.ConnectivityManager
import com.ihorvitruk.telegramclient.domain.exception.NoNetworkException
import com.ihorvitruk.telegramclient.domain.repository.INetworkRepository
import kotlinx.coroutines.experimental.async


class NetworkRepository(private val appContext: Context): INetworkRepository {

    override fun checkNetworkConnection() = async {
        val connectivityManager = appContext.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager.activeNetworkInfo == null
                || !connectivityManager.activeNetworkInfo.isAvailable
                || !connectivityManager.activeNetworkInfo.isConnected) {
            throw NoNetworkException()
        }
    }
}
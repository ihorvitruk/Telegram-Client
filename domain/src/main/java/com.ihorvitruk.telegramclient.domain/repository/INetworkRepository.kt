package com.ihorvitruk.telegramclient.domain.repository

import kotlinx.coroutines.experimental.Deferred
import com.ihorvitruk.telegramclient.domain.exception.NoNetworkException

interface INetworkRepository {

    /**
     * @throws NoNetworkException
     */
    fun checkNetworkConnection(): Deferred<Unit>
}
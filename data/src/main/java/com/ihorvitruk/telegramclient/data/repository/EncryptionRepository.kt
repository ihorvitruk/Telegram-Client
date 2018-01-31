package com.ihorvitruk.telegramclient.data.repository

import com.ihorvitruk.telegramclient.domain.repository.IEncryptionRepository
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred

class EncryptionRepository: IEncryptionRepository {
    override fun encrypt(plainText: String): Deferred<String> {
        return CompletableDeferred()
    }

    override fun decrypt(cipherData: String): Deferred<String> {
        return CompletableDeferred()
    }
}
package com.ihorvitruk.telegramclient.data.repository

import com.ihorvitruk.telegramclient.domain.repository.IEncryptionRepository
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred
import java.security.Key

class EncryptionRepository : IEncryptionRepository {

    override fun encrypt(plainText: String?, key: Key): Deferred<String?> {
        return CompletableDeferred()
    }

    override fun decrypt(cipherData: String?, key: Key): Deferred<String?> {
        return CompletableDeferred()
    }
}
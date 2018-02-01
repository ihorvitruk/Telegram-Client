package com.ihorvitruk.telegramclient.data.repository

import com.ihorvitruk.telegramclient.domain.repository.IEncryptionKeyRepository
import kotlinx.coroutines.experimental.Deferred
import java.security.Key

class EncryptionKeyRepository : IEncryptionKeyRepository {

    override fun createKey(): Deferred<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readKey(): Deferred<Key> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
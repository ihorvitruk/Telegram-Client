package com.ihorvitruk.telegramclient.domain.repository

import kotlinx.coroutines.experimental.Deferred
import java.security.Key

interface IEncryptionKeyRepository {

    fun createKey(/*TODO some input password?*/): Deferred<Unit>

    fun readKey(): Deferred<Key>
}
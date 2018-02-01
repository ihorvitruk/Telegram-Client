package com.ihorvitruk.telegramclient.domain.repository

import kotlinx.coroutines.experimental.Deferred
import java.security.KeyPair

interface IEncryptionKeyRepository {

    fun readKeyPair(): Deferred<KeyPair?>

    fun deleteKeyPair(): Deferred<Unit>
}
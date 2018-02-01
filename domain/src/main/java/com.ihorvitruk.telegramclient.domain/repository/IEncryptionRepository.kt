package com.ihorvitruk.telegramclient.domain.repository

import kotlinx.coroutines.experimental.Deferred
import java.security.Key

interface IEncryptionRepository {

    fun encrypt(plainText: String?, key: Key): Deferred<String?>

    fun decrypt(cipherData: String?, key: Key): Deferred<String?>
}
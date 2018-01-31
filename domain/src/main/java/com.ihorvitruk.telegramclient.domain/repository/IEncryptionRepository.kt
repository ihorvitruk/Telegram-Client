package com.ihorvitruk.telegramclient.domain.repository

import kotlinx.coroutines.experimental.Deferred

interface IEncryptionRepository {

    fun encrypt(plainText: String): Deferred<String>

    fun decrypt(cipherData: String): Deferred<String>
}
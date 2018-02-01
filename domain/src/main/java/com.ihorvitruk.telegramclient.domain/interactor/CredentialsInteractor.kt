package com.ihorvitruk.telegramclient.domain.interactor

import com.ihorvitruk.telegramclient.domain.repository.IEncryptionRepository
import com.ihorvitruk.telegramclient.domain.repository.IKeyRepository
import com.ihorvitruk.telegramclient.domain.repository.IKeyValueRepository
import kotlinx.coroutines.experimental.async

class CredentialsInteractor(private val keyValueRepository: IKeyValueRepository,
                            private val keyRepository: IKeyRepository,
                            private val encryptionRepository: IEncryptionRepository) {

    private val KEY_API_ID = "api_id"
    private val KEY_API_HASH = "api_hash"

    fun readApiId() = readCredential(KEY_API_ID)

    fun writeApiId(apiId: String) = writeCredential(KEY_API_ID, apiId)

    fun readApiHash() = readCredential(KEY_API_HASH)

    fun writeApiHash(apiHash: String) = writeCredential(KEY_API_HASH, apiHash)

    private fun readCredential(key: String) = async {
        val cipheredCred = keyValueRepository.read(key).await()
        val encryptionKey = keyRepository.readKey().await()
        val cred = encryptionRepository.decrypt(cipheredCred, encryptionKey).await()
        cred
    }

    private fun writeCredential(key: String, credential: String) = async {
        val encryptionKey = keyRepository.readKey().await()
        val cipheredCred = encryptionRepository.encrypt(credential, encryptionKey).await()
        keyValueRepository.create(key, cipheredCred)
    }
}
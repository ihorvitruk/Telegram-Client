package com.ihorvitruk.telegramclient.domain.interactor

import com.ihorvitruk.telegramclient.domain.repository.IEncryptionRepository
import com.ihorvitruk.telegramclient.domain.repository.IEncryptionKeyRepository
import com.ihorvitruk.telegramclient.domain.repository.IKeyValueRepository
import kotlinx.coroutines.experimental.async

class CredentialsInteractor(private val keyValueRepository: IKeyValueRepository,
                            private val encryptionKeyRepository: IEncryptionKeyRepository,
                            private val encryptionRepository: IEncryptionRepository) {

    companion object {
        private val KEY_API_ID = "api_id"
        private val KEY_API_HASH = "api_hash"
    }

    fun readApiId() = readCredential(KEY_API_ID)

    fun writeApiId(apiId: String) = writeCredential(KEY_API_ID, apiId)

    fun readApiHash() = readCredential(KEY_API_HASH)

    fun writeApiHash(apiHash: String) = writeCredential(KEY_API_HASH, apiHash)

    private fun readCredential(key: String) = async {
        val cipheredCred = keyValueRepository.read(key).await()
        val encryptionKey = encryptionKeyRepository.readKeyPair().await()
        val cred = encryptionRepository.decrypt(cipheredCred, encryptionKey?.private).await()
        cred
    }

    private fun writeCredential(key: String, credential: String) = async {
        val encryptionKey = encryptionKeyRepository.readKeyPair().await()
        val cipheredCred = encryptionRepository.encrypt(credential, encryptionKey?.public).await()
        keyValueRepository.create(key, cipheredCred)
    }
}
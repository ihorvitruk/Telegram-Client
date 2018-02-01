package com.ihorvitruk.telegramclient.data.repository

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.security.KeyPairGeneratorSpec
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.ihorvitruk.telegramclient.domain.repository.IEncryptionKeyRepository
import kotlinx.coroutines.experimental.async
import java.math.BigInteger
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.PrivateKey
import java.util.*
import javax.security.auth.x500.X500Principal

class EncryptionKeyRepository(private val context: Context) : IEncryptionKeyRepository {

    companion object {
        private val KEY_STORE_TYPE = "AndroidKeyStore"
        private val KEY_STORE_ALIAS = "MAIN_KEY"
        private val ENCRYPTION_ALGORITHM = "RSA"
    }

    private val keyStore = createAndroidKeyStore()

    override fun readKeyPair() = async {
        val keyPair = readRSAKeyPair(KEY_STORE_ALIAS)
        when (keyPair == null) {
            true -> createRSAKeyPair(KEY_STORE_ALIAS)
            false -> keyPair
        }
    }

    //TODO Consider when and where to use it
    override fun deleteKeyPair() = async {
        keyStore.deleteEntry(KEY_STORE_ALIAS)
    }

    private fun createAndroidKeyStore(): KeyStore {
        val keyStore = KeyStore.getInstance(KEY_STORE_TYPE)
        keyStore.load(null)
        return keyStore
    }

    private fun createRSAKeyPair(alias: String): KeyPair {
        val generator = KeyPairGenerator.getInstance(ENCRYPTION_ALGORITHM, KEY_STORE_TYPE)

        when (hasMarshmallow()) {
            true -> initGeneratorWithKeyGenParameterSpec(generator, alias)
            false -> initGeneratorWithKeyPairGeneratorSpec(generator, alias)
        }
        return generator.generateKeyPair()
    }

    private fun readRSAKeyPair(alias: String): KeyPair? {
        val privateKey = keyStore.getKey(alias, null) as PrivateKey?
        val publicKey = keyStore.getCertificate(alias)?.publicKey

        return if (privateKey != null && publicKey != null) {
            KeyPair(publicKey, privateKey)
        } else {
            null
        }
    }

    private fun initGeneratorWithKeyPairGeneratorSpec(generator: KeyPairGenerator, alias: String) {
        val startDate = Calendar.getInstance()
        val endDate = Calendar.getInstance()
        endDate.add(Calendar.YEAR, 20)

        val builder = KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)
                .setSerialNumber(BigInteger.ONE)
                .setSubject(X500Principal("CN=${alias} CA Certificate"))
                .setStartDate(startDate.time)
                .setEndDate(endDate.time)

        generator.initialize(builder.build())
    }

    @TargetApi(Build.VERSION_CODES.M)
    private fun initGeneratorWithKeyGenParameterSpec(generator: KeyPairGenerator, alias: String) {
        val builder = KeyGenParameterSpec.Builder(alias,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
        generator.initialize(builder.build())
    }

    private fun hasMarshmallow() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
}
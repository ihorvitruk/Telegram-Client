package com.ihorvitruk.telegramclient.data.repository

import android.util.Base64
import com.ihorvitruk.telegramclient.domain.repository.IEncryptionRepository
import kotlinx.coroutines.experimental.async
import java.security.Key
import javax.crypto.Cipher

class EncryptionRepository : IEncryptionRepository {

    companion object {
        private val transformation = "RSA/ECB/PKCS1Padding"
    }

    private val cipher = Cipher.getInstance(transformation)

    override fun encrypt(plainText: String, key: Key) = async {
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val bytes = cipher.doFinal(plainText.toByteArray())
        Base64.encodeToString(bytes, Base64.DEFAULT)
    }

    override fun decrypt(cipherData: String?, key: Key) = async {
        cipher.init(Cipher.DECRYPT_MODE, key)
        val cipherDataBytes = Base64.decode(cipherData, Base64.DEFAULT)
        val data = cipher.doFinal(cipherDataBytes)
        String(data)
    }
}
package com.ihorvitruk.telegramclient.data.repository

import com.ihorvitruk.telegramclient.domain.entity.auth.AuthState
import com.ihorvitruk.telegramclient.domain.repository.IAuthRepository
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred

class AuthRepository(private val apiId: String,
                     private val apiHash: String,
                     private val databaseDirectory: String,
                     private val filesDirectory: String,
                     private val deviceModel: String,
                     private val systemVersion: String,
                     private val systemLanguageCode: String) : TdLibRepository(), IAuthRepository {
    override fun sendCode(phoneNumber: String): Deferred<Void> {
        return CompletableDeferred()
    }

    override fun getAuthState(): Deferred<AuthState> {
        return CompletableDeferred()
    }

    override fun checkCode(code: Int): Deferred<Void> {
        return CompletableDeferred()
    }

    override fun logout(): Deferred<Void> {
        return CompletableDeferred()
    }
}

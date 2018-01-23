package com.ihorvitruk.telegramclient.domain.repository

import com.ihorvitruk.telegramclient.domain.entity.account.AuthState
import kotlinx.coroutines.experimental.Deferred

interface IAuthRepository {

    fun sendCode(phoneNumber: String): Deferred<Void>

    fun getAuthState(): Deferred<AuthState>

    fun checkCode(code: Int): Deferred<Void>

    fun logout(): Deferred<Void>
}
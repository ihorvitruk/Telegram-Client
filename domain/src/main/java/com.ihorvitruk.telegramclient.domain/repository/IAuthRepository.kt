package com.ihorvitruk.telegramclient.domain.repository

import com.ihorvitruk.telegramclient.domain.entity.auth.AuthState
import kotlinx.coroutines.experimental.Deferred

interface IAuthRepository {

    fun sendCode(phoneNumber: String): Deferred<Unit>

    fun getAuthState(): Deferred<AuthState>

    fun checkCode(code: Int): Deferred<Unit>

    fun logout(): Deferred<Unit>
}
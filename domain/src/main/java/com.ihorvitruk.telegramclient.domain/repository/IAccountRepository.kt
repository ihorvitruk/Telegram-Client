package com.ihorvitruk.telegramclient.domain.repository

import com.ihorvitruk.telegramclient.domain.entity.account.Account
import kotlinx.coroutines.experimental.Deferred

interface IAccountRepository {

    fun readAccount(): Deferred<Account>

    fun saveAccount(): Deferred<Unit>

    fun deleteAccount(): Deferred<Unit>
}
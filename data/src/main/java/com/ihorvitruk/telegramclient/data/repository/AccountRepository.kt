package com.ihorvitruk.telegramclient.data.repository

import com.ihorvitruk.telegramclient.domain.entity.account.Account
import com.ihorvitruk.telegramclient.domain.repository.IAccountRepository
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred

class AccountRepository: IAccountRepository {

    override fun readAccount(): Deferred<Account> {
        return CompletableDeferred()
    }

    override fun saveAccount(): Deferred<Unit> {
        return CompletableDeferred()
    }

    override fun deleteAccount(): Deferred<Unit> {
        return CompletableDeferred()
    }
}
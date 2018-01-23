package com.ihorvitruk.telegramclient.data.repository

import android.os.SystemClock
import com.ihorvitruk.telegramclient.domain.entity.account.Account
import com.ihorvitruk.telegramclient.domain.repository.IAccountRepository
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

class AccountRepository : IAccountRepository {

    override fun readAccount(): Deferred<Account> {
        val deferred = CompletableDeferred<Account>()
        async {
            SystemClock.sleep(6000)
            deferred.complete(Account("", "Ihor", "Vitruk"))
        }
        return deferred
    }

    override fun saveAccount(): Deferred<Void> {
        return CompletableDeferred()
    }

    override fun deleteAccount(): Deferred<Void> {
        return CompletableDeferred()
    }
}
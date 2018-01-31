package com.ihorvitruk.telegramclient.data.repository

import com.ihorvitruk.telegramclient.domain.repository.IValueRepository
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred

class ValueRepository : IValueRepository {
    override fun create(key: String, value: String): Deferred<String> {
        return CompletableDeferred()
    }

    override fun read(key: String): Deferred<String> {
        return CompletableDeferred()
    }

    override fun update(key: String, newValue: String): Deferred<String> {
        return CompletableDeferred()
    }

    override fun delete(key: String): Deferred<Unit> {
        return CompletableDeferred()
    }
}
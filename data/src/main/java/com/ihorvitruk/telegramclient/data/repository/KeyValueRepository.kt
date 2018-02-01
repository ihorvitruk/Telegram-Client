package com.ihorvitruk.telegramclient.data.repository

import com.ihorvitruk.telegramclient.domain.repository.IKeyValueRepository
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred

class KeyValueRepository : IKeyValueRepository {
    override fun create(key: String, value: String?): Deferred<Unit> {
        return CompletableDeferred()
    }

    override fun read(key: String): Deferred<String> {
        return CompletableDeferred()
    }

    override fun update(key: String, newValue: String?): Deferred<Unit> {
        return CompletableDeferred()
    }

    override fun delete(key: String): Deferred<Unit> {
        return CompletableDeferred()
    }
}
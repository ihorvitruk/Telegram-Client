package com.ihorvitruk.telegramclient.domain.repository

import kotlinx.coroutines.experimental.Deferred

interface IValueRepository {

    fun create(key: String, value: String): Deferred<String>

    fun read(key: String): Deferred<String>

    fun update(key: String, newValue: String): Deferred<String>

    fun delete(key: String): Deferred<Unit>
}
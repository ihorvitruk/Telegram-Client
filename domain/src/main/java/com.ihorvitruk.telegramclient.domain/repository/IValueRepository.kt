package com.ihorvitruk.telegramclient.domain.repository

import kotlinx.coroutines.experimental.Deferred

interface IValueRepository {

    fun create(key: String, value: String?): Deferred<Unit>

    fun read(key: String): Deferred<String?>

    fun update(key: String, newValue: String?): Deferred<Unit>

    fun delete(key: String): Deferred<Unit>
}
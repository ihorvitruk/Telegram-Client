package com.ihorvitruk.telegramclient.app.di.module

import com.ihorvitruk.telegramclient.data.repository.*
import com.ihorvitruk.telegramclient.domain.repository.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bind(impl: AuthRepository): IAuthRepository

    @Singleton
    @Binds
    fun bind(impl: EncryptionKeyRepository): IEncryptionKeyRepository

    @Singleton
    @Binds
    fun bind(impl: EncryptionRepository): IEncryptionRepository

    @Singleton
    @Binds
    fun bind(impl: KeyValueRepository): IKeyValueRepository

    @Singleton
    @Binds
    fun bind(impl: NetworkRepository): INetworkRepository
}
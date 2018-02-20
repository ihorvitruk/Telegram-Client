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
    fun bindAuthRepository(impl: AuthRepository): IAuthRepository

    @Singleton
    @Binds
    fun bindEncryptionKeyRepository(impl: EncryptionKeyRepository): IEncryptionKeyRepository

    @Singleton
    @Binds
    fun bindEncryptionRepository(impl: EncryptionRepository): IEncryptionRepository

    @Singleton
    @Binds
    fun bindKeyValueRepository(impl: KeyValueRepository): IKeyValueRepository

    @Singleton
    @Binds
    fun bindNetworkRepository(impl: NetworkRepository): INetworkRepository
}
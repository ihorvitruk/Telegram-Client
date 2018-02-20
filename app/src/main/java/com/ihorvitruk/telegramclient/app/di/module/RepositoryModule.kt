package com.ihorvitruk.telegramclient.app.di.module

import com.ihorvitruk.telegramclient.data.repository.*
import com.ihorvitruk.telegramclient.domain.repository.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindAuthRepository(impl: AuthRepository): IAuthRepository

    @Singleton
    @Binds
    abstract fun bindEncryptionKeyRepository(impl: EncryptionKeyRepository): IEncryptionKeyRepository

    @Singleton
    @Binds
    abstract fun bindEncryptionRepository(impl: EncryptionRepository): IEncryptionRepository

    @Singleton
    @Binds
    abstract fun bindKeyValueRepository(impl: KeyValueRepository): IKeyValueRepository

    @Singleton
    @Binds
    abstract fun bindNetworkRepository(impl: NetworkRepository): INetworkRepository
}
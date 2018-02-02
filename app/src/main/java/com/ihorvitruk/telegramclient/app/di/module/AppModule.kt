package com.ihorvitruk.telegramclient.app.di.module

import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

@Module(
        includes = [
            AndroidSupportInjectionModule::class,
            RepositoryModule::class
        ]
)
interface AppModule {

}
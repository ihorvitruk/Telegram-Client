package com.ihorvitruk.telegramclient.app.di.module

import com.ihorvitruk.telegramclient.app.activity.SingleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(
        includes = [
            AndroidSupportInjectionModule::class,
            RepositoryModule::class
        ]
)
interface AppModule {

    @ContributesAndroidInjector()
    fun activityInjector(): SingleActivity
}
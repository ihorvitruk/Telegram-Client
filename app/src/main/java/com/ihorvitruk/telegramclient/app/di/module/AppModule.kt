package com.ihorvitruk.telegramclient.app.di.module

import android.content.Context
import com.ihorvitruk.telegramclient.app.App
import com.ihorvitruk.telegramclient.app.activity.AppActivity
import com.ihorvitruk.telegramclient.data.repository.*
import com.ihorvitruk.telegramclient.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Binds
    abstract fun app(application: App): Context

    @ContributesAndroidInjector
    abstract fun appActivity(): AppActivity
}
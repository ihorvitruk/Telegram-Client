package com.ihorvitruk.telegramclient.app

import android.app.Activity
import com.ihorvitruk.telegramclient.app.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


class App : DaggerApplication() {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.builder().create(this)


    override fun activityInjector() = activityDispatchingAndroidInjector
}
package com.ihorvitruk.telegramclient.app.di.component

import android.content.Context
import com.ihorvitruk.telegramclient.app.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import com.ihorvitruk.telegramclient.app.App



@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}

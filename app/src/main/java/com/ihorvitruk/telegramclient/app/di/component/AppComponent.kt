package com.ihorvitruk.telegramclient.app.di.component

import com.ihorvitruk.telegramclient.app.App
import com.ihorvitruk.telegramclient.app.di.module.AppModule
import com.ihorvitruk.telegramclient.app.di.module.RepositoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*Classes that should be injected:

Repository - singleton

Router - activity scope
Interactor - view scope
ViewModel - view scope

*/
@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            RepositoryModule::class
        ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}

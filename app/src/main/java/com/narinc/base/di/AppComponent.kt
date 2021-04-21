package com.narinc.base.di

import android.app.Application
import com.narinc.base.BaseApplication
import com.narinc.base.di.module.ActivityBuilderModule
import com.narinc.base.di.module.AppModule
import com.narinc.base.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ContextModule::class,
    AppModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}
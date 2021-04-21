package com.narinc.base.di.module

import dagger.Module

@Module(includes = [
    ViewModelModule::class,
    ClientModule::class])
class AppModule {

}
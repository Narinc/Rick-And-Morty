package com.narinc.base.di.module

import androidx.lifecycle.ViewModelProvider
import com.narinc.base.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?
}
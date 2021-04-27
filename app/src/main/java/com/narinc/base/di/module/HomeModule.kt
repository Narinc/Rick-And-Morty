package com.narinc.base.di.module

import com.narinc.base.data.api.HomeItemService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object HomeModule {
    @Provides
    fun provideHomeItemService(retrofit: Retrofit): HomeItemService =
        retrofit.create(HomeItemService::class.java)

}
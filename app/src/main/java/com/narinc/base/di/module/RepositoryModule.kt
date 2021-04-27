package com.narinc.base.di.module

import com.narinc.base.data.api.HomeItemService
import com.narinc.base.data.db.AppDatabase
import com.narinc.base.data.source.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewssterRepository(
        service: HomeItemService,
        database: AppDatabase
    ): CharacterRepository {
        return CharacterRepository(service, database)
    }
}
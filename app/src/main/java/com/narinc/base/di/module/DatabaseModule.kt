package com.narinc.base.di.module

import android.app.Application
import androidx.room.Room
import com.narinc.base.data.db.AppDatabase
import com.narinc.base.data.db.ItemDao
import com.narinc.base.data.db.RemoteKeysDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, "items.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticleDao(newssterDatabase: AppDatabase): ItemDao {
        return newssterDatabase.itemDao()
    }

    @Provides
    fun provideRemoteKeysDao(newssterDatabase: AppDatabase): RemoteKeysDao {
        return newssterDatabase.remoteKeysDao()
    }
}
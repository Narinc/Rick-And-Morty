package com.narinc.base.data.source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.narinc.base.data.api.HomeItemService
import com.narinc.base.data.db.AppDatabase
import com.narinc.base.data.model.Item
import com.narinc.base.paging.ItemRemoteMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val service: HomeItemService,
    private val database: AppDatabase
) {

    @ExperimentalPagingApi
    fun getRemoteAndLocalFlow(): Flow<PagingData<Item>> {
        val pagingSourceFactory =
            {
                database.itemDao().getAllItems()
            }
        return Pager(
            config = PagingConfig(5),
            remoteMediator = ItemRemoteMediator(database, service),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}

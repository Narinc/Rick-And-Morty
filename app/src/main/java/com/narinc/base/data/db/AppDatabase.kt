package com.narinc.base.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.narinc.base.data.model.Item
import com.narinc.base.data.model.ItemTypeConverter
import com.narinc.base.data.model.RemoteKeys

@Database(entities = [Item::class, RemoteKeys::class],version = 1, exportSchema = false)
@TypeConverters(ItemTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {
	
	abstract fun itemDao():ItemDao
	
	abstract fun remoteKeysDao():RemoteKeysDao
}
package com.narinc.base.data.model

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


object ItemTypeConverter {

    private fun createAdapter(): JsonAdapter<List<String>> {
        val type =
            Types.newParameterizedType(List::class.java, String::class.java)
        return Moshi.Builder().build().adapter<List<String>>(type)
    }

    @TypeConverter
    fun restoreList(listOfString: String): List<String>? {
        return createAdapter().fromJson(listOfString)
    }

    @TypeConverter
    fun saveList(listOfString: List<String>): String? {
        return createAdapter().toJson(listOfString)
    }
}
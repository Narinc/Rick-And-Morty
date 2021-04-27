package com.narinc.base.ui.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.narinc.base.data.model.Item
import com.narinc.base.data.source.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    fun loadCharacters() : Flow<PagingData<Item>> {
        return repository.getRemoteAndLocalFlow()
    }

}
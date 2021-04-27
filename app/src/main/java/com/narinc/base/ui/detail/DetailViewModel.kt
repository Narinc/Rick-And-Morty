package com.narinc.base.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {

    val _showEpisodes = MutableLiveData<Boolean>(false)

    val showEpisodes: LiveData<Boolean>
        get() = _showEpisodes


    fun select() {
        _showEpisodes.value = _showEpisodes.value?.not()
    }
}
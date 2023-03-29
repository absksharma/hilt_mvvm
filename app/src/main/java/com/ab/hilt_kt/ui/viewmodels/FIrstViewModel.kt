package com.ab.hilt_kt.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.hilt_kt.data.models.ImagesResponse
import com.ab.hilt_kt.data.repos.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FirstViewModel @Inject constructor(private val repo: MainRepo) : ViewModel() {

    private var _list = MutableLiveData<ImagesResponse>()
    val list: LiveData<ImagesResponse> = _list

    fun fetchDogs() = viewModelScope.launch() {
        val list = repo.getData().body()
        _list.value = list!!
    }
}
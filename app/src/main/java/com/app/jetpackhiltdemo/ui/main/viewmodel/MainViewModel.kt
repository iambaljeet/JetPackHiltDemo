package com.app.jetpackhiltdemo.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.app.jetpackhiltdemo.model.RepositoriesModel
import com.app.jetpackhiltdemo.network.ResultData
import com.app.jetpackhiltdemo.usecase.DataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val dataUseCase: DataUseCase
) : ViewModel() {

    val repositoryListLiveData: MutableLiveData<ResultData<RepositoriesModel?>> =
        MutableLiveData()

    fun getRepositoriesList(since: String) {
        viewModelScope.launch {
            dataUseCase.getRepositoriesList(since = since).onEach {
                repositoryListLiveData.postValue(it)
            }.collect()
        }
    }
}
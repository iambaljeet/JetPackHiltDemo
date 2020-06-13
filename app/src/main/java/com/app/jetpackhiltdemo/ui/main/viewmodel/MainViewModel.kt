package com.app.jetpackhiltdemo.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.app.jetpackhiltdemo.model.RepositoriesModel
import com.app.jetpackhiltdemo.network.ResultData
import com.app.jetpackhiltdemo.usecase.DataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class MainViewModel @ViewModelInject constructor(
    private val dataUseCase: DataUseCase
): ViewModel() {
    fun getRepositoriesList(since: String): LiveData<ResultData<RepositoriesModel?>> {
        return flow {
            emit(ResultData.Loading())
            try {
                emit(dataUseCase.getRepositoriesList(since = since))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ResultData.Exception())
            }
        }.asLiveData(Dispatchers.IO)
    }
}
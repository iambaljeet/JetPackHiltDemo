package com.app.jetpackhiltdemo.usecase

import com.app.jetpackhiltdemo.model.RepositoriesModel
import com.app.jetpackhiltdemo.network.ResultData
import com.app.jetpackhiltdemo.repository.DataRepository
import javax.inject.Inject

class DataUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {
    suspend fun getRepositoriesList(since: String): ResultData<RepositoriesModel> {
        val repositoriesModel = dataRepository.getRepositoriesList(since = since)

        val resultData = when(repositoriesModel.isNotEmpty()) {
            true -> {
                ResultData.Success(repositoriesModel)
            }
            else -> {
                ResultData.Failed()
            }
        }
        return resultData
    }
}
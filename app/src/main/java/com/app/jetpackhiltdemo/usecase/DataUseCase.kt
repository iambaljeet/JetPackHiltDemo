package com.app.jetpackhiltdemo.usecase

import com.app.jetpackhiltdemo.model.RepositoriesModel
import com.app.jetpackhiltdemo.network.ResultData
import com.app.jetpackhiltdemo.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {
    suspend fun getRepositoriesList(since: String): Flow<ResultData<RepositoriesModel>> {
        return flow {
            emit(ResultData.Loading)

            val repositoriesModel = dataRepository.getRepositoriesList(since = since)

            val resultData = if (repositoriesModel.isNullOrEmpty()) {
                ResultData.Failed()
            } else {
                ResultData.Success(repositoriesModel)
            }

            emit(resultData)
        }.catch {
            emit(ResultData.Failed())
        }
    }
}
package com.app.jetpackhiltdemo.repository

import com.app.jetpackhiltdemo.model.RepositoriesModel
import com.app.jetpackhiltdemo.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getRepositoriesList(since: String): RepositoriesModel {
        return apiService.getPublicRepositories(since = since)
    }
}
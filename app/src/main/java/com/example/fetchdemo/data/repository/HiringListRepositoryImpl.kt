package com.example.fetchdemo.data.repository

import com.example.fetchdemo.data.model.HiringItem
import com.example.fetchdemo.data.model.toDataModel
import com.example.fetchdemo.data.remote.HiringListApiService
import javax.inject.Inject

class HiringListRepositoryImpl @Inject constructor(
    private val listApi: HiringListApiService,
) : HiringListRepository {

    override suspend fun getList(): List<HiringItem> {
        return listApi.getItems().map {
            it.toDataModel()
        }
    }
}
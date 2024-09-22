package com.example.fetchdemo.data.remote

import com.example.fetchdemo.data.remote.model.HiringItemResponse
import retrofit2.http.GET

interface HiringListApiService {

    @GET("hiring.json")
    suspend fun getItems(): List<HiringItemResponse>
}
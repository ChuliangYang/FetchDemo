package com.example.fetchdemo.data.repository

import com.example.fetchdemo.data.model.HiringItem

interface HiringListRepository {
    suspend fun getList(): List<HiringItem>
}
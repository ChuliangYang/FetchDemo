package com.example.fetchdemo.data.model

import com.example.fetchdemo.data.remote.model.HiringItemResponse

data class HiringItem(
    val id: Int,
    val listId: Int,
    val name: String?,
)

fun HiringItemResponse.toDataModel() = HiringItem(
    id = id,
    listId = listId,
    name = name,
)
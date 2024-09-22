package com.example.fetchdemo.ui.feature.list

import com.example.fetchdemo.data.model.HiringItem

sealed interface HiringListScreenState {
    data object Loading : HiringListScreenState
    data class Error(val message: String) : HiringListScreenState
    data class Display(val hiringLists: List<SectionHiringList>) : HiringListScreenState
}

data class SectionHiringList(
    val section: String,
    val hiringList: List<HiringItemUI>
)

data class HiringItemUI(
    val id: String,
    val name: String,
)

fun HiringItem.toUIModel() = HiringItemUI(
    id = id.toString(),
    name = name.toString(),
)


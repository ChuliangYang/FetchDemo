package com.example.fetchdemo.domain

import com.example.fetchdemo.data.model.HiringItem
import com.example.fetchdemo.data.repository.HiringListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchListUseCase @Inject constructor(private val hiringListRepository: HiringListRepository) {
    suspend fun execute(): List<Pair<Int, List<HiringItem>>> {
        val list = hiringListRepository.getList()

        val resultList = withContext(Dispatchers.Default) {
            list.asSequence()
                .filter {
                    !it.name.isNullOrBlank()
                }
                .groupBy {
                    it.listId
                }
                .map { entry ->
                    entry.key to entry.value.sortedBy { it.name?.split(" ")?.last()?.toInt() }
                }
                .toList()
                .sortedBy { (listId, _) -> listId }
        }

        return resultList
    }
}
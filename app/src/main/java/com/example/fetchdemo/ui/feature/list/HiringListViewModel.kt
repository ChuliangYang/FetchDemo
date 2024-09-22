package com.example.fetchdemo.ui.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchdemo.domain.FetchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HiringListViewModel @Inject constructor(
    private val fetchListUseCase: FetchListUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<HiringListScreenState>(HiringListScreenState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchHiringList()
    }

    private fun fetchHiringList() {
        viewModelScope.launch {
            val result = runCatching {
                fetchListUseCase.execute()
            }

            result.onSuccess { pairList ->
                _uiState.value = HiringListScreenState.Display(pairList.map { pairItem ->
                    SectionHiringList(
                        "List ID: ${pairItem.first}",
                        pairItem.second.map {
                            it.toUIModel()
                        }
                    )
                })
            }.onFailure {
                _uiState.value = HiringListScreenState.Error(it.localizedMessage ?: "")
            }
        }
    }
}



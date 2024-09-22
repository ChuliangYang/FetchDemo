package com.example.fetchdemo.ui.feature.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HiringListScreen(
    viewModel: HiringListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Hiring List") },
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            )
        )
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            when (val state = uiState) {
                is HiringListScreenState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }

                is HiringListScreenState.Error -> {
                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center),
                        text = "Error: ${state.message}",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                is HiringListScreenState.Display -> {
                    HiringListContent(hiringLists = state.hiringLists)
                }
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HiringListContent(hiringLists: List<SectionHiringList>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        hiringLists.forEach { section ->
            stickyHeader {
                SectionHeader(sectionTitle = section.section)
            }
            items(section.hiringList) { hiringItem ->
                HiringItemRow(hiringItem = hiringItem)
            }
        }
    }
}

@Composable
fun SectionHeader(sectionTitle: String) {
    Text(
        text = sectionTitle,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(12.dp)
    )
}

@Composable
fun HiringItemRow(hiringItem: HiringItemUI) {
    ListItem(
        headlineContent = {
            Text(
                hiringItem.name,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
    )
}

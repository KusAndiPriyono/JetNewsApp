package com.example.jetnewsapp.presentation.search

import androidx.paging.PagingData
import com.bangkit.jetnewsapp.database.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)

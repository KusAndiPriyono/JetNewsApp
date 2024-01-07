package com.bangkit.jetnewsapp.home.domain.usecases.news

import androidx.paging.PagingData
import com.bangkit.jetnewsapp.database.model.Article
import com.bangkit.jetnewsapp.home.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNews @Inject constructor(
    private val newsRepository: com.bangkit.jetnewsapp.home.domain.repository.NewsRepository
) {
    operator fun invoke(searchQuery: String, source: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery, sources = source)
    }
}
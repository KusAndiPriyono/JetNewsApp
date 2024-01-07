package com.bangkit.jetnewsapp.home.domain.usecases.news

import androidx.paging.PagingData
import com.bangkit.jetnewsapp.database.model.Article
import com.bangkit.jetnewsapp.home.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources)
    }
}
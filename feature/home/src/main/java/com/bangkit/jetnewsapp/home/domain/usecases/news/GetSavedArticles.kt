package com.bangkit.jetnewsapp.home.domain.usecases.news

import com.bangkit.jetnewsapp.database.dao.NewsDao
import com.bangkit.jetnewsapp.database.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}
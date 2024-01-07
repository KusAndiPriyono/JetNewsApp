package com.bangkit.jetnewsapp.home.domain.usecases.news

import com.bangkit.jetnewsapp.database.dao.NewsDao
import com.bangkit.jetnewsapp.database.model.Article
import javax.inject.Inject

class InsertArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article) {
        newsDao.insert(article = article)
    }
}
package com.bangkit.jetnewsapp.home.domain.usecases.news

import com.bangkit.jetnewsapp.database.dao.NewsDao
import com.bangkit.jetnewsapp.database.model.Article
import javax.inject.Inject

class GetSaveArticle @Inject constructor(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(url: String): Article? {
        return newsDao.getArticle(url = url)
    }
}

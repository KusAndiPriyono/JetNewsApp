package com.bangkit.jetnewsapp.bookmark

import com.bangkit.jetnewsapp.database.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)

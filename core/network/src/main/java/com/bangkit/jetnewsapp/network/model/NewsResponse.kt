package com.bangkit.jetnewsapp.network.model

import com.bangkit.jetnewsapp.database.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
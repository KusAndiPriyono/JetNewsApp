package com.bangkit.jetnewsapp.home.presentation.details

import com.bangkit.jetnewsapp.database.model.Article

sealed class DetailsEvent {
    data class InsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()
}

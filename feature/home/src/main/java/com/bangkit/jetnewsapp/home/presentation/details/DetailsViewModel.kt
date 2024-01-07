package com.bangkit.jetnewsapp.home.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.jetnewsapp.database.model.Article
import com.bangkit.jetnewsapp.designsystem.util.UIComponent
import com.bangkit.jetnewsapp.home.domain.usecases.news.DeleteArticle
import com.bangkit.jetnewsapp.home.domain.usecases.news.GetSaveArticle
import com.bangkit.jetnewsapp.home.domain.usecases.news.InsertArticle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getSavedArticleUseCase: GetSaveArticle,
    private val deleteArticleUseCase: DeleteArticle,
    private val insertArticleUseCase: InsertArticle,
) : ViewModel() {
    var sideEffect by mutableStateOf<UIComponent?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.InsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = getSavedArticleUseCase(url = event.article.url)
                    if (article == null) {
                        insertArticle(article = event.article)
                    } else {
                        deleteArticle(article = event.article)
                    }
                }
            }

            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        deleteArticleUseCase(article = article)
        sideEffect = UIComponent.Toast("Article deleted")
    }

    private suspend fun insertArticle(article: Article) {
        insertArticleUseCase(article = article)
        sideEffect = UIComponent.Toast("Article Inserted")
    }
}
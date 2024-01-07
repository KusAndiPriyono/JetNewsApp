package com.bangkit.jetnewsapp.home.presentation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.bangkit.jetnewsapp.database.model.Article
import com.bangkit.jetnewsapp.designsystem.common.SearchBar
import com.bangkit.jetnewsapp.designsystem.util.Dimens
import com.bangkit.jetnewsapp.home.ArticlesList
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    state: HomeState,
    event: (HomeEvent) -> Unit,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = "\uD83D\uDFE5") { it.title }
            } else {
                ""
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.MediumPadding1)
            .statusBarsPadding()
    ) {
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        SearchBar(
            modifier = Modifier
                .padding(horizontal = Dimens.SearchPadding)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = navigateToSearch,
            onSearch = {}
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        val scrollState = rememberScrollState(initial = state.scrollValue)

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState, enabled = false),
            fontSize = 12.sp,
            color = colorResource(id = com.bangkit.jetnewsapp.designsystem.R.color.black)
        )

        LaunchedEffect(key1 = scrollState.maxValue) {
            event(HomeEvent.UpdateMaxScrollingValue(scrollState.maxValue))
        }

        LaunchedEffect(key1 = scrollState.value) {
            event(HomeEvent.UpdateScrollValue(scrollState.value))
        }

        LaunchedEffect(key1 = state.maxScrollingValue) {
            delay(500)
            if (state.maxScrollingValue > 0) {
                scrollState.animateScrollTo(
                    value = state.maxScrollingValue,
                    animationSpec = infiniteRepeatable(
                        tween(
                            durationMillis = (state.maxScrollingValue - state.scrollValue) * 50_000 / state.maxScrollingValue,
                            easing = LinearEasing,
                            delayMillis = 1000
                        )
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        ArticlesList(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            articles = articles,
            onClick = navigateToDetails
        )
    }
}

package com.example.jetnewsapp.presentation.onboarding

import androidx.annotation.DrawableRes

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val onboardPages = listOf(
    Page(
        title = "Welcome to Jetnews",
        description = "Jetnews is an app built to demonstrate the use of Jetpack Compose.",
        image = com.bangkit.jetnewsapp.designsystem.R.drawable.onboarding1
    ),
    Page(
        title = "Explore the feed",
        description = "Jetnews provides a feed of articles organized by topic so you can stay up to date on the latest news.",
        image = com.bangkit.jetnewsapp.designsystem.R.drawable.onboarding2
    ),
    Page(
        title = "Bookmark interesting articles",
        description = "Save articles to your personal reading list.",
        image = com.bangkit.jetnewsapp.designsystem.R.drawable.onboarding3
    ),
)

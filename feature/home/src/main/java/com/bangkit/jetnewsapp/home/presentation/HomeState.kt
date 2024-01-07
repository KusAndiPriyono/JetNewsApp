package com.bangkit.jetnewsapp.home.presentation

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
    val scrollValue: Int = 0,
    val maxScrollingValue: Int = 0,
)

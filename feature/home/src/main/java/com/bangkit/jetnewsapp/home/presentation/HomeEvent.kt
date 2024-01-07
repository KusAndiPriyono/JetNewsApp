package com.bangkit.jetnewsapp.home.presentation

sealed class HomeEvent {
    data class UpdateScrollValue(val newValue: Int) : HomeEvent()
    data class UpdateMaxScrollingValue(val newValue: Int) : HomeEvent()
}

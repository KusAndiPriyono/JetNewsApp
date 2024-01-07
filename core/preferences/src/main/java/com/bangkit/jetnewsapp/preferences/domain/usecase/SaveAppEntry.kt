package com.bangkit.jetnewsapp.preferences.domain.usecase

import com.bangkit.jetnewsapp.preferences.domain.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: com.bangkit.jetnewsapp.preferences.domain.LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}
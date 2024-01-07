package com.bangkit.jetnewsapp.preferences.domain.usecase

import com.bangkit.jetnewsapp.preferences.domain.LocalUserManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(
    private val localUserManager: com.bangkit.jetnewsapp.preferences.domain.LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}
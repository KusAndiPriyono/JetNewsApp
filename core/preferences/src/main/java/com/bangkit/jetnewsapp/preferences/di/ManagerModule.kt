package com.bangkit.jetnewsapp.preferences.di

import com.bangkit.jetnewsapp.preferences.data.LocalUserManagerImpl
import com.bangkit.jetnewsapp.preferences.domain.LocalUserManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ManagerModule {

    @Binds
    @Singleton
    abstract fun bindLocalUserManger(localUserManagerImpl: LocalUserManagerImpl): LocalUserManager
}
package com.bangkit.jetnewsapp.network.di

import android.app.Application
import androidx.room.Room
import com.bangkit.jetnewsapp.database.NewsDatabase
import com.bangkit.jetnewsapp.database.converter.NewsTypeConverter
import com.bangkit.jetnewsapp.database.dao.NewsDao
import com.bangkit.jetnewsapp.network.NewsApi
import com.bangkit.jetnewsapp.network.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(application: Application): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConverter()).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.newsDao
}
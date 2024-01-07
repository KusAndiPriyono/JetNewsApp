package com.bangkit.jetnewsapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bangkit.jetnewsapp.database.dao.NewsDao
import com.bangkit.jetnewsapp.database.model.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(com.bangkit.jetnewsapp.database.converter.NewsTypeConverter::class)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newsDao: NewsDao
}
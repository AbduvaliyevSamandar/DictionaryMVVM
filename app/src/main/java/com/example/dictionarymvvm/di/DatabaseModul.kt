package com.example.dictionarymvvm.di

import android.content.Context
import androidx.annotation.MainThread
import androidx.room.Room
import com.example.dictionarymvvm.data.dao.AppDatabase
import com.example.dictionarymvvm.data.dao.DictionaryDao
import com.example.dictionarymvvm.data.reponsitory.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okio.IOException
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModul {
    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context
    @Provides
    @Singleton
    fun provideAppdatabase(@ApplicationContext context: Context):AppDatabase{
        return  Room.databaseBuilder(context,AppDatabase::class.java,"dictionary")
            .allowMainThreadQueries()
            .build()
    }
    @Provides
    @Singleton
    fun provideDictionaryDao(appDatabase: AppDatabase):DictionaryDao{
        return appDatabase.dictionaryDao()
    }
}
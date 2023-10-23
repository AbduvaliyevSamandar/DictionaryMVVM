package com.example.dictionarymvvm.di

import com.example.dictionarymvvm.data.reponsitory.MainRepository
import com.example.dictionarymvvm.data.reponsitory.MainRepositoryImpl
import com.example.dictionarymvvm.datasource.DictionaryDataSource
import com.example.dictionarymvvm.datasource.DictionaryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModul {

    @Singleton
    @Binds
    fun provideMainRepositoryImpl(dataSource: DictionaryDataSourceImpl): DictionaryDataSource

}
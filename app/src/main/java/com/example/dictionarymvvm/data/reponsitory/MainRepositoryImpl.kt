package com.example.dictionarymvvm.data.reponsitory

import com.example.dictionarymvvm.datasource.DictionaryDataSource
import com.example.dictionarymvvm.model.Dictionary
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(private val dictionaryDataSource: DictionaryDataSource): MainRepository {
    override suspend fun getDictionary(): List<Dictionary> {
        return dictionaryDataSource.getContacts()
    }

    override suspend fun insertAll(list: ArrayList<Dictionary>) {
        dictionaryDataSource.insertAll(list)
    }

    override suspend fun searchUz(query: String): List<Dictionary> {
       return dictionaryDataSource.searchUz(query)
    }

    override suspend fun searchEn(query: String): List<Dictionary> {
       return dictionaryDataSource.searchEn(query)

    }
}
package com.example.dictionarymvvm.datasource

import com.example.dictionarymvvm.AllWords
import com.example.dictionarymvvm.data.dao.AppDatabase
import com.example.dictionarymvvm.data.dao.DictionaryDao
import com.example.dictionarymvvm.model.Dictionary
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

class DictionaryDataSourceImpl @Inject constructor(private val database: AppDatabase) :DictionaryDataSource{

    override suspend fun getContacts(): List<Dictionary> {
    return database.dictionaryDao().getWords()
}

    override suspend fun insertAll(list: ArrayList<Dictionary> ){
        if (database.dictionaryDao().getWords().isEmpty()){
            database.dictionaryDao().insert(list)
        }
    }

    override suspend fun searchUz(query: String):List<Dictionary> {
        return database.dictionaryDao().searchUzWords(query)
    }

    override suspend fun searchEn(query: String):List<Dictionary> {
       return database.dictionaryDao().searchEnWords(query)
    }
}
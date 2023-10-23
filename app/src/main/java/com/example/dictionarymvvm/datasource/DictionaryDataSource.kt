package com.example.dictionarymvvm.datasource

import com.example.dictionarymvvm.model.Dictionary


interface DictionaryDataSource {
     suspend fun getContacts(): List<Dictionary>
     suspend fun insertAll(list: ArrayList<Dictionary>)
     suspend fun searchUz(query:String):List<Dictionary>
     suspend fun searchEn(query:String):List<Dictionary>
}
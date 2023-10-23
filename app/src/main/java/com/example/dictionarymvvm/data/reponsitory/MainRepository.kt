package com.example.dictionarymvvm.data.reponsitory

import com.example.dictionarymvvm.App
import com.example.dictionarymvvm.model.Dictionary
import com.example.dictionarymvvm.model.DictionaryType

interface MainRepository {
    suspend fun getDictionary(): List<Dictionary>
    suspend fun insertAll(list:ArrayList<Dictionary>)
    suspend fun searchUz(query:String):List<Dictionary>
    suspend fun searchEn(query:String):List<Dictionary>

}
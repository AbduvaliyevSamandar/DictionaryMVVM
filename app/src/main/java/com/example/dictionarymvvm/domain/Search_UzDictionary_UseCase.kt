package com.example.dictionarymvvm.domain

import com.example.dictionarymvvm.model.Dictionary
import com.example.dictionarymvvm.data.reponsitory.MainRepository
import javax.inject.Inject

class Search_UzDictionary_UseCase @Inject constructor(private val repository: MainRepository) {
    suspend operator fun invoke(query:String): List<Dictionary> {
      return  repository.searchUz(query)


    }

}
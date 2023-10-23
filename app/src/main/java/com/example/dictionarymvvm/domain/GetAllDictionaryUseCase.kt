package com.example.dictionarymvvm.domain

import com.example.dictionarymvvm.model.Dictionary
import com.example.dictionarymvvm.data.reponsitory.MainRepository
import javax.inject.Inject

class GetAllDictionaryUseCase @Inject constructor(private val repository: MainRepository) {
    suspend operator fun invoke(): List<Dictionary> {
        return repository.getDictionary()
    }
}
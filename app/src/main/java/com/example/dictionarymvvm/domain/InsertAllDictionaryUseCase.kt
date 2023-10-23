package com.example.dictionarymvvm.domain

import com.example.dictionarymvvm.AllWords
import com.example.dictionarymvvm.model.Dictionary
import com.example.dictionarymvvm.data.reponsitory.MainRepository
import javax.inject.Inject

class InsertAllDictionaryUseCase @Inject constructor(private val repository: MainRepository) {
    suspend operator fun invoke(list: ArrayList<Dictionary>): State {
        //    if (phone.length != 13) return State.Error(VALIDATION_ERROR)

       // val entity = Dictionary(0, firstName, lastName)
        repository.insertAll(list)

        return State.Success
    }

}
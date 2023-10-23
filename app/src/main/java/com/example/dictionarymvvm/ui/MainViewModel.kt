package com.example.dictionarymvvm.ui

import android.annotation.SuppressLint
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionarymvvm.domain.GetAllDictionaryUseCase
import com.example.dictionarymvvm.domain.InsertAllDictionaryUseCase
import com.example.dictionarymvvm.domain.Search_EnDictionary_UseCase
import com.example.dictionarymvvm.domain.Search_UzDictionary_UseCase
import com.example.dictionarymvvm.domain.State
import com.example.dictionarymvvm.model.Dictionary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val addContactsUseCase: InsertAllDictionaryUseCase,
    private val getAllDictionaryUseCase: GetAllDictionaryUseCase,
    private val searchUzDictionary: Search_UzDictionary_UseCase,
    private val searchEnDictionary: Search_EnDictionary_UseCase,
) : ViewModel() {

    private val _dictionary = MutableLiveData<List<Dictionary>>()
    val dictionary: LiveData<List<Dictionary>> get() = _dictionary

    init {
        getContacts()
    }

    fun insertAll(list: ArrayList<Dictionary>) {
        viewModelScope.launch(Dispatchers.IO) {
            when (addContactsUseCase(list)) {
                State.Success, is State.SuccessData<*> -> getContacts()
                is State.Error -> {} //errorLiveData.value = "error"
            }
        }
    }
    fun searchUz(query:String) {
        viewModelScope.launch(Dispatchers.IO) {
          _dictionary.postValue(searchUzDictionary(query)!!)
        }
    }
    fun searchEn(query:String) {
        viewModelScope.launch(Dispatchers.IO) {
            _dictionary.postValue(searchEnDictionary(query)!!)
        }
    }



    @SuppressLint("NullSafeMutableLiveData")
    fun getContacts() {
        viewModelScope.launch(Dispatchers.IO) {
            _dictionary.postValue(getAllDictionaryUseCase())
        }
    }

}
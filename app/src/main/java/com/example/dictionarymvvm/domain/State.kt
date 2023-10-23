package com.example.dictionarymvvm.domain

sealed class State {
    object Success : State()
    class SuccessData<T>(val data: T) : State()
    class Error(val code: Int) : State()
}

const val VALIDATION_ERROR = 12
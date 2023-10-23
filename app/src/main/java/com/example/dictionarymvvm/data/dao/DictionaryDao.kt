package com.example.dictionarymvvm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dictionarymvvm.model.Dictionary

@Dao
interface DictionaryDao {
    @Insert
    fun insert(dictionary: Dictionary)
    @Insert
    fun insert(dictionary: List<Dictionary>)


    @Query("SELECT * FROM dictionaries")
    fun getWords(): List<Dictionary>

    @Query("SELECT * FROM dictionaries WHERE word_en LIKE :query || '%'")
    fun searchEnWords(query: String): List<Dictionary>

        @Query("SELECT * FROM dictionaries WHERE word_uz LIKE :query || '%'")
        fun searchUzWords(query: String): List<Dictionary>
}
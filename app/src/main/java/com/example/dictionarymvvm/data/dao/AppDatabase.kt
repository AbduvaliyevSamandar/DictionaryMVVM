package com.example.dictionarymvvm.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dictionarymvvm.model.Dictionary

@Database(entities = [Dictionary::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dictionaryDao(): DictionaryDao
}


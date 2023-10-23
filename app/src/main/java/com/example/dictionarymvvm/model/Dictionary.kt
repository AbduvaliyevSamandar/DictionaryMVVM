package com.example.dictionarymvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dictionaries")
class Dictionary(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0L,
    @ColumnInfo("word_uz")
    val wordUz: String,
    @ColumnInfo("word_en")
    val wordEn: String
)
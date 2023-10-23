package com.example.dictionarymvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionarymvvm.ui.MainFragment
import com.example.dictionarymvvm.ui.MenuFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container,MenuFragment())
            .commit()
    }
}
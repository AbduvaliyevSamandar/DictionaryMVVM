package com.example.dictionarymvvm.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictionarymvvm.R
import com.example.dictionarymvvm.databinding.FragmentMenuBinding

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val binding: FragmentMenuBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.wordEn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container,MainFragment::class.java, bundleOf("type" to 0))
                .addToBackStack("MenuFragment")
                .commit()
        }
        binding.wordUz.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container,MainFragment::class.java, bundleOf("type" to 1))
                .addToBackStack("MenuFragment")
                .commit()
        }
    }

}
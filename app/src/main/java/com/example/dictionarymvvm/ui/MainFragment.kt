package com.example.dictionarymvvm.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictionarymvvm.R
import com.example.dictionarymvvm.model.Dictionary
import com.example.dictionarymvvm.model.DictionaryType
import com.example.dictionarymvvm.AllWords
import com.example.dictionarymvvm.adapter.DictionaryAdapter
import com.example.dictionarymvvm.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: DictionaryAdapter

    private var type = DictionaryType.EN_UZ
    private lateinit var data: ArrayList<Dictionary>


    private  val binding: FragmentMainBinding by viewBinding()

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       binding.recyler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.HORIZONTAL
            )
       )
        val i = arguments?.getInt("type", -1)
        if (i == 1) {
            type = DictionaryType.UZ_EN
        } else if (i == 0) {
            type = DictionaryType.EN_UZ
        }
        viewModel.insertAll(AllWords().addWords())
        data = ArrayList()

        adapter = DictionaryAdapter(data, type)
        binding.recyler.adapter = adapter

        viewModel.dictionary.observe(viewLifecycleOwner) { posts ->
            adapter.setList(posts)
            data.clear()
            data.addAll(posts)
        }
        adapter.setOnClickListener { indeks ->
            Toast.makeText(requireContext(), indeks.toString(), Toast.LENGTH_SHORT).show()
            val alerDialog = AlertDialog.Builder(requireContext())
            val dialog = alerDialog.create()
            dialog.setTitle("Tarjimon")

            if (i == 0) {
                dialog.setMessage(data[indeks].wordUz)
            } else if (i == 1) {
                dialog.setMessage("\n" + data[indeks].wordEn + "\n")
            }
            dialog.show()
        }
        binding.search.addTextChangedListener {
            val query = it?.toString()
            if (query.isNullOrEmpty()) {
                data.clear()
                adapter.setList(AllWords().addWords())
                adapter.notifyDataSetChanged()
                return@addTextChangedListener
            }
            if (i == 1) {
                viewModel.searchUz(query)
            } else if (i == 0) {
                viewModel.searchEn(query)
            }
        }

    }

}
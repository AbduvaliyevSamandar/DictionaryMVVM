package com.example.dictionarymvvm.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionarymvvm.R
import com.example.dictionarymvvm.model.Dictionary
import com.example.dictionarymvvm.model.DictionaryType

class DictionaryAdapter(
    private var data: List<Dictionary>,
    private val type: DictionaryType
) : RecyclerView.Adapter<DictionaryViewHolder>() {

    fun setList(list: List<Dictionary>) {
        data = list
        notifyDataSetChanged()
    }

    private var onClickListener: ((Int) -> (Unit))? = null
    fun setOnClickListener(clickListener: (Int) -> Unit) {
        onClickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder {

        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.item_dictionary, parent, false)
        return DictionaryViewHolder(inflate, onClickListener)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        holder.bind(data[position], type)
    }

}

class DictionaryViewHolder(view: View, listener: ((Int) -> Unit)?) : RecyclerView.ViewHolder(view) {
    private val word: TextView = view.findViewById(R.id.word)

    private val layout: LinearLayout = view.findViewById(R.id.layout)

    init {
        layout.setOnClickListener {
            listener?.invoke(bindingAdapterPosition)
        }
    }

    fun bind(dictionary: Dictionary, type: DictionaryType) {
        word.text = when (type) {
            DictionaryType.EN_UZ -> dictionary.wordEn
            DictionaryType.UZ_EN -> dictionary.wordUz
        }
    }


}
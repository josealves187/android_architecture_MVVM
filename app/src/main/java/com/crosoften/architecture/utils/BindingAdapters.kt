package com.crosoften.architecture.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.crosoften.architecture.utils.extension.getParentActivity


/**
 * Documento do qual é implementado funções utilitárias para o Data Binding.
 **/

/**
 *  Função responsável por setar um adapter via Data Binding em um recyclerView
 *  @param view RecyclerView a ser setado o adapter
 *  @param adapter Adapter a ser setado no RecyclerView
 * */
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

/**
 *  Função responsável por dar visibilidade em uma view
 *  @param view view a ser definida a visibilidade
 *  @param visibility visibilidade definida (View.GONE ou View.VISIBLE)
 * */
@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

/**
 *  Função responsável por setar texto dinamicamente em um TextView
 *  @param view TextView a ser setado o texto.
 *  @param text texto a ser setado no TextView.
 * */
@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }
}
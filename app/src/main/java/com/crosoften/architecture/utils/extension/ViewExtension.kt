package com.crosoften.architecture.utils.extension

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity


/**
 * Documento do qual é implementado métodos de extensão de Views
 * de forma que toda classe View e suas filhas possam usar tais métodos
 **/

/**
 *  Método responável por retornar o contexto de activity da view em questão.
 *  @return context
 **/
fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}
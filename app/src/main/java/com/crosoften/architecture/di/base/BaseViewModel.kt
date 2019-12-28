package com.crosoften.architecture.di.base

import androidx.lifecycle.ViewModel
import com.crosoften.architecture.di.component.DaggerViewModelInjector
import com.crosoften.architecture.di.component.ViewModelInjector
import com.crosoften.architecture.di.module.NetworkModule
import com.crosoften.architecture.viewmodel.PostListViewModel
import com.crosoften.architecture.viewmodel.PostViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injeta as dependências necessárias
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}
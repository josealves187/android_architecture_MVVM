package com.crosoften.architecture.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.crosoften.architecture.data.database.AppDatabase
import com.crosoften.architecture.viewmodel.PostListViewModel

/**
 * Classe de instanciação do banco na inicialização da Aplicação
 * no ato de instanciação do ViewModel passando como entrada
 * no construtor uma instancia do postDao
 * */
class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts").build()
            @Suppress("UNCHECKED_CAST")
            return PostListViewModel(db.postDao()) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")

    }
}
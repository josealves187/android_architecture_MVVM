package com.crosoften.architecture.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.crosoften.architecture.data.dao.PostDao
import com.crosoften.architecture.data.entities.Post

/**
 * Classe de configuração do banco de dados e de lançamento das interfaces de DAO.
 * @constructor constrtutor utilizado para inicializar o banco.
 * @property entities classes de Entidades Utilizadas na criação do banco.
 * @property version inteiro de versionamento do banco.
 * @property exportSchema booleano referente a exportação ou nao do banco.
 * */
@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
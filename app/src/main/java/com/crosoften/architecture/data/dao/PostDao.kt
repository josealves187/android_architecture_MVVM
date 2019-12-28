package com.crosoften.architecture.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.crosoften.architecture.data.entities.Post

/**
 * Interface que fornece os métodos de manipulação da entidade Post no Banco.
 */
@Dao
interface PostDao {

    /**
     * Obter a lista de posts da API
     * @return uma lista de Postagens.
     */
    @get:Query("SELECT * FROM post")
    val all: List<Post>

    /**
     * Adiciona uma listagem de postagem no banco de dados
     * na tabela Post.
     * @param users entrando com uma lista de Postagens.
     */
    @Insert
    fun insertAll(vararg users: Post)
}
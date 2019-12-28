package com.crosoften.architecture.network.services

import com.crosoften.architecture.data.entities.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Interface que fornece métodos para obter o resultado de webservices
 */

interface PostApi {
    /**
     * Obter a lista de posts da API
     * @return uma lista observável de Postagens.
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}
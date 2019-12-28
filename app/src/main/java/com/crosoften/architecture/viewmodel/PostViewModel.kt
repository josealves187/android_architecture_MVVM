package com.crosoften.architecture.viewmodel

import androidx.lifecycle.MutableLiveData
import com.crosoften.architecture.data.entities.Post
import com.crosoften.architecture.di.base.BaseViewModel

class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    /**
     * Método de set de valores nos objetos postTitle e postBody.
     * @param post Objeto Post.
     * */
    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    /**
     * Método de get do LiveData postTitle.
     * @return postTitle uma String referente ao título.
     * */
    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    /**
     * Método de get do LiveData postBody
     * @return postBody uma String referente ao corpo da postagem.
     * */
    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}
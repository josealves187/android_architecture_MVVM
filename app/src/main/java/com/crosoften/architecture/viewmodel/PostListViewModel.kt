package com.crosoften.architecture.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.crosoften.architecture.R
import com.crosoften.architecture.data.dao.PostDao
import com.crosoften.architecture.data.entities.Post
import com.crosoften.architecture.di.base.BaseViewModel
import com.crosoften.architecture.network.services.PostApi
import com.crosoften.architecture.view.adapters.PostListAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel(private val postDao: PostDao) : BaseViewModel() {

    // Injetando a a dependencia do service PostApi
    @Inject
    lateinit var postApi: PostApi

    // Variáveis utilizadas pelo ViewModel.
    val postListAdapter: PostListAdapter = PostListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    // Variável de acumulo de inscrições.
    private lateinit var subscription: Disposable

    // Inicializando o carregamento de postagens
    init {
        loadPosts()
    }

    // Método de remoção de inscrições do RXJava, mediante ao fim do ciclo de vida do viewModel.
    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    /**
     * Método responsável por realizar o carregamento
     * das postagens utilizadas nos contextos utilizados.
     * Primeiramente ele verifica se está populada a tabela Post no banco,
     * caso tenha é carregado o conteúdo do banco, se não tiver é buscado na api e inserido no banco
     **/
    private fun loadPosts() {
        subscription = Observable.fromCallable { postDao.all }
                .concatMap { dbPostList ->
                    if (dbPostList.isEmpty())
                        postApi.getPosts().concatMap { apiPostList ->
                            postDao.insertAll(*apiPostList.toTypedArray())
                            Observable.just(apiPostList)
                        }
                    else
                        Observable.just(dbPostList)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { result -> onRetrievePostListSuccess(result) },
                        { onRetrievePostListError() }
                )
    }

    /**
     * Método de inicialização da apresentação do progress
     */
    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    /**
     * Método de finalização da apresentação do progress
     */
    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    /**
     * Método apresentação do carregamento bem sucedido da listagem de postagens.
     */
    private fun onRetrievePostListSuccess(postList: List<Post>) {
        postListAdapter.updatePostList(postList)
    }

    /**
     * Método apresentação de erro ao buscar listagem de postagens.
     */
    private fun onRetrievePostListError() {
        errorMessage.value = R.string.error_post
    }

}
package com.crosoften.architecture.di.module

import com.crosoften.architecture.network.services.PostApi
import com.crosoften.architecture.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Módulo que fornece todas as dependências necessárias sobre rede
 * esta intanciadas pelo Retrofit.
 */
@Module
// Seguro aqui, pois estamos lidando com um módulo Dagger 2
@Suppress("unused")
object NetworkModule {

    /**
     * Fornece a implementação do serviço de Postagens
     * @param retrofit o objeto Retrofit usado para instanciar o serviço
     * @return a implementação do Post Service.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    /**
     * Fornece o objeto Retrofit.
     * @return o objeto Retrofit
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}
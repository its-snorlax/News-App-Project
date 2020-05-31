package com.juniorjainsahab.newsapp.network

import com.juniorjainsahab.newsapp.network.ApiParam.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder() {

    companion object {
        fun <T> build(clazz: Class<T>?): T {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(clazz)
        }

    }
}
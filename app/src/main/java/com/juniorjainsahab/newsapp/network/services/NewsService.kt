package com.juniorjainsahab.newsapp.network.services

import com.juniorjainsahab.newsapp.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") param1: String,
        @Query("apiKey") param2: String
    ): Call<NewsModel>
}
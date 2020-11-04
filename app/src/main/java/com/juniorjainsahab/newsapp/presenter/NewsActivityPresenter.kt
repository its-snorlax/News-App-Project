package com.juniorjainsahab.newsapp.presenter

import com.juniorjainsahab.newsapp.model.NewsModel
import com.juniorjainsahab.newsapp.network.ApiParam
import com.juniorjainsahab.newsapp.network.services.NewsService
import com.juniorjainsahab.newsapp.view.NewsActivityView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsActivityPresenter(val view: NewsActivityView, private val service: NewsService) {
    fun getArticles() {
        view.showProgressBar()
        service.getTopHeadlines("in", ApiParam.API_KEY)
            .enqueue(object : Callback<NewsModel> {
                override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                    view.hideProgressBar()
                    view.onRequestFail()
                }

                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                    view.hideProgressBar()
                    if (response.isSuccessful) {
                        val newsModel = response.body()
                        view.onRequestSuccess(newsModel)
                    }
                }
            })
    }
}
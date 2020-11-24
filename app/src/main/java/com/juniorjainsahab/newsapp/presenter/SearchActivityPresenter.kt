package com.juniorjainsahab.newsapp.presenter

import com.juniorjainsahab.newsapp.model.NewsModel
import com.juniorjainsahab.newsapp.network.ApiParam
import com.juniorjainsahab.newsapp.network.services.NewsService
import com.juniorjainsahab.newsapp.view.SearchFragmentView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivityPresenter(
    private val searchFragmentView: SearchFragmentView,
    private val searchService: NewsService
) {
    fun search(newText: String) {
        searchFragmentView.showProgressBar()
        searchService.getSearchResults(newText, ApiParam.API_KEY)
            .enqueue(object : Callback<NewsModel> {
                override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                    searchFragmentView.hideProgressBar()
                    searchFragmentView.onFail()
                }

                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                    searchFragmentView.hideProgressBar()
                    if (response.isSuccessful) {
                        searchFragmentView.onSuccess(response.body())
                        return
                    }
                    searchFragmentView.onFail()
                }
            })
    }
}

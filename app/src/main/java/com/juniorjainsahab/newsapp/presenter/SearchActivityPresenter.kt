package com.juniorjainsahab.newsapp.presenter

import com.juniorjainsahab.newsapp.model.NewsModel
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
        searchService.getSearchResults(newText, "7cb8b3ac7c4745b5a8ba6f50becde20d")
            .enqueue(object : Callback<NewsModel> {
                override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                    searchFragmentView.onFail()
                }

                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                    if (response.isSuccessful) {
                        searchFragmentView.onSuccess(response.body())
                        return
                    }
                    searchFragmentView.onFail()
                }
            })
        searchFragmentView.hideProgressBar()
    }
}

package com.juniorjainsahab.newsapp.view

import com.juniorjainsahab.newsapp.model.NewsModel

interface SearchFragmentView {
    fun showProgressBar()
    fun onFail()
    fun onSuccess(body: NewsModel?)
    fun hideProgressBar()
}
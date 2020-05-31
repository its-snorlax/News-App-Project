package com.juniorjainsahab.newsapp.view

import com.juniorjainsahab.newsapp.model.NewsModel

interface NewsActivityView {
    fun onRequestSuccess(newsModel: NewsModel?)
    fun onRequestFail()
    fun showProgressBar()
    fun hideProgressBar()
}
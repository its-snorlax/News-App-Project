package com.juniorjainsahab.newsapp

import android.widget.SearchView
import com.juniorjainsahab.newsapp.network.ServiceBuilder
import com.juniorjainsahab.newsapp.network.services.NewsService
import com.juniorjainsahab.newsapp.presenter.SearchActivityPresenter
import com.juniorjainsahab.newsapp.view.SearchFragmentView

class SearchQueryListener(private val searchFragmentView: SearchFragmentView) :
    SearchView.OnQueryTextListener {

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null && query.isNotEmpty()) {
            SearchActivityPresenter(searchFragmentView, ServiceBuilder.build(NewsService::class.java))
                .search(query)
        }
        return true

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null && newText.isNotEmpty()) {
            SearchActivityPresenter(searchFragmentView, ServiceBuilder.build(NewsService::class.java))
                .search(newText)
        }
        return true
    }
}

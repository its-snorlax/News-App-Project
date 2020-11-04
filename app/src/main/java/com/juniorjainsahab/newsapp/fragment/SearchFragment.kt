package com.juniorjainsahab.newsapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.activity.ArticleDetailActivity
import com.juniorjainsahab.newsapp.adapter.ArticlesAdapter
import com.juniorjainsahab.newsapp.model.Articles
import com.juniorjainsahab.newsapp.model.NewsModel
import com.juniorjainsahab.newsapp.view.SearchFragmentView

class SearchFragment : Fragment(), SearchFragmentView, View.OnClickListener {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var articles: List<Articles>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progress_bar)
        recyclerView = view.findViewById(R.id.list_view)
    }

    override fun onSuccess(searchItem: NewsModel?) {
        if (searchItem != null) {
            articles = searchItem.articles
            val articlesAdapter = ArticlesAdapter(articles, this)
            recyclerView.layoutManager = LinearLayoutManager(context);
            recyclerView.adapter = articlesAdapter
        }

    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onFail() {
        Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onClick(v: View?) {
        if (v != null) {
            val position = recyclerView.getChildLayoutPosition(v)
            val currentClickedItem = articles[position]
            openArticleDetailActivity(currentClickedItem)
        }
    }

    private fun openArticleDetailActivity(activityContent: Articles) {
        val intent = Intent(context, ArticleDetailActivity::class.java)
        intent.putExtra("activityContent", activityContent)
        startActivity(intent)
    }
}

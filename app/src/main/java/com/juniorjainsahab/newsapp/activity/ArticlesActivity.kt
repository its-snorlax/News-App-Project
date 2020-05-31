package com.juniorjainsahab.newsapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.adapter.ArticlesAdapter
import com.juniorjainsahab.newsapp.model.Articles
import com.juniorjainsahab.newsapp.model.NewsModel
import com.juniorjainsahab.newsapp.network.ServiceBuilder
import com.juniorjainsahab.newsapp.network.services.NewsService
import com.juniorjainsahab.newsapp.presenter.NewsActivityPresenter
import com.juniorjainsahab.newsapp.view.NewsActivityView

class ArticlesActivity : AppCompatActivity(), NewsActivityView, View.OnClickListener {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var articles: List<Articles>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_bar)
        recyclerView = findViewById(R.id.list_view)

        NewsActivityPresenter(this, ServiceBuilder.build(NewsService::class.java)).getArticles()
    }

    override fun onRequestSuccess(newsModel: NewsModel?) {
        if (newsModel != null) {
            articles = newsModel.articles
            val articlesAdapter = ArticlesAdapter(articles, this)
            recyclerView.layoutManager = LinearLayoutManager(this);
            recyclerView.adapter = articlesAdapter
        }
    }

    override fun onRequestFail() {
        Toast.makeText(this, "Request Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
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
        val intent = Intent(baseContext, ArticleDetailActivity::class.java)
        intent.putExtra("activityContent", activityContent)
        startActivity(intent)
    }
}

package com.juniorjainsahab.newsapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.R.layout.fragment_articles
import com.juniorjainsahab.newsapp.adapter.ArticlesAdapter
import com.juniorjainsahab.newsapp.model.Articles
import com.juniorjainsahab.newsapp.model.NewsModel
import com.juniorjainsahab.newsapp.network.ServiceBuilder
import com.juniorjainsahab.newsapp.network.services.NewsService
import com.juniorjainsahab.newsapp.presenter.SearchActivityPresenter
import com.juniorjainsahab.newsapp.view.SearchFragmentView

class CategoryArticlesActivity : AppCompatActivity(), SearchFragmentView, View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var articles: List<Articles>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(fragment_articles)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.list_view)
        progressBar = findViewById(R.id.progress_bar)

        val categoryName = intent.getStringExtra("categoryName")
        supportActionBar?.title = categoryName
        SearchActivityPresenter(this, ServiceBuilder.build(NewsService::class.java))
            .search(categoryName)
    }

    override fun showProgressBar() {
        progressBar.visibility = VISIBLE
    }

    override fun onFail() {
        Toast.makeText(this, "Request Fail", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(newsModel: NewsModel?) {
        if (newsModel != null) {
            articles = newsModel.articles
            val articlesAdapter = ArticlesAdapter(articles, this)
            recyclerView.layoutManager = LinearLayoutManager(this);
            recyclerView.adapter = articlesAdapter
        }
    }

    override fun hideProgressBar() {
        progressBar.visibility = GONE
    }

    override fun onClick(v: View?) {
        if (v != null) {
            val position = recyclerView.getChildLayoutPosition(v)
            val currentClickedItem = articles[position]
            openArticleDetailActivity(currentClickedItem)
        }
    }

    private fun openArticleDetailActivity(activityContent: Articles) {
        val intent = Intent(this, ArticleDetailActivity::class.java)
        intent.putExtra("activityContent", activityContent)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
package com.juniorjainsahab.newsapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juniorjainsahab.newsapp.R.id.list_view
import com.juniorjainsahab.newsapp.R.id.no_data_message
import com.juniorjainsahab.newsapp.R.layout.activity_favorite
import com.juniorjainsahab.newsapp.adapter.ArticlesAdapter
import com.juniorjainsahab.newsapp.asyncTask
import com.juniorjainsahab.newsapp.db.AppDB
import com.juniorjainsahab.newsapp.db.OnExecuteListener
import com.juniorjainsahab.newsapp.db.entity.ArticlesEntity
import com.juniorjainsahab.newsapp.model.Articles

class FavoriteActivity : AppCompatActivity(), OnExecuteListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noFavoriteMessage: LinearLayout

    private lateinit var favArticles: List<ArticlesEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_favorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Favorite"

        recyclerView = findViewById(list_view)
        noFavoriteMessage = findViewById(no_data_message)

        asyncTask({
            favArticles = AppDB.getDbInstance(this).articlesDao().getAll()
        }, this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onQuerySuccess() {
        val articles =
            favArticles.map { Articles(it.title, it.urlToImage, it.description, it.url) }

        if (articles.isNotEmpty()) {
            noFavoriteMessage.visibility = GONE
            recyclerView.visibility = VISIBLE

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ArticlesAdapter(articles,
                View.OnClickListener {
                    val activityContent = articles[recyclerView.getChildLayoutPosition(it)]
                    openArticleDetailActivity(activityContent)
                })
        }
    }

    private fun openArticleDetailActivity(activityContent: Articles) {
        val intent = Intent(this, ArticleDetailActivity::class.java)
        intent.putExtra("activityContent", activityContent)
        startActivity(intent)
    }
}
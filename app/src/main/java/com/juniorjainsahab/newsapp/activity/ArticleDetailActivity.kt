package com.juniorjainsahab.newsapp.activity

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.R.id.add_to_fav
import com.juniorjainsahab.newsapp.R.id.share
import com.juniorjainsahab.newsapp.R.menu.activity_article_detail_menu
import com.juniorjainsahab.newsapp.db.AppDB
import com.juniorjainsahab.newsapp.db.entity.ArticlesEntity
import com.juniorjainsahab.newsapp.model.Articles
import com.squareup.picasso.Picasso


class ArticleDetailActivity : AppCompatActivity(), MenuItem.OnMenuItemClickListener {

    private lateinit var activityContent: Articles
    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var knowMoreButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        activityContent = intent.getSerializableExtra("activityContent") as Articles
        imageView = findViewById(R.id.image_view)
        titleTextView = findViewById(R.id.title_text_view)
        descriptionTextView = findViewById(R.id.description_text_view)
        knowMoreButton = findViewById(R.id.know_more_button)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Picasso.get().load(activityContent.urlToImage).resize(
            Resources.getSystem().displayMetrics.widthPixels,
            Resources.getSystem().displayMetrics.widthPixels / 2
        ).into(imageView)
        titleTextView.text = activityContent.title
        descriptionTextView.text = activityContent.description
        knowMoreButton.setOnClickListener {
            val intent = Intent(baseContext, CustomWebView::class.java)
            intent.putExtra("url", activityContent.url)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(activity_article_detail_menu, menu)
        menu?.findItem(share)?.setOnMenuItemClickListener(this)
        menu?.findItem(add_to_fav)?.setOnMenuItemClickListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            share -> {
                share()
                return true
            }
            add_to_fav -> {
                addToFavourite()
                return true
            }
        }
        return false
    }

    private fun addToFavourite() {
        InsertionDBAsyncTask(applicationContext, activityContent).execute()
    }

    private fun share() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, activityContent.url + "\n" + activityContent.title)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share this Article"))
    }

    private class InsertionDBAsyncTask(
        private val context: Context,
        private val dbContent: Articles
    ) :
        AsyncTask<Void?, Void?, Int>() {
        override fun doInBackground(vararg params: Void?): Int {
            val dbInstance = AppDB.getDbInstance(context)
            dbInstance.articlesDao().insertAll(
                ArticlesEntity(
                    title = dbContent.title,
                    urlToImage = dbContent.urlToImage,
                    url = dbContent.url,
                    description = dbContent.description
                )
            )
            return 0;
        }
    }
}
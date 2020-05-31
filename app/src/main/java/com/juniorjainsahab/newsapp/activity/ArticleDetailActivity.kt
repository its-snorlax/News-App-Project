package com.juniorjainsahab.newsapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.model.Articles
import com.squareup.picasso.Picasso

class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var activityContent: Articles
    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var contentTextView: TextView
    private lateinit var knowMoreButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        activityContent = intent.getSerializableExtra("activityContent") as Articles
        imageView = findViewById(R.id.image_view)
        titleTextView = findViewById(R.id.title_text_view)
        descriptionTextView = findViewById(R.id.description_text_view)
        contentTextView = findViewById(R.id.content_text_view)
        knowMoreButton = findViewById(R.id.know_more_button)

        Picasso.get().load(activityContent.urlToImage).into(imageView)
        titleTextView.text = activityContent.title
        descriptionTextView.text = activityContent.description
        contentTextView.text = activityContent.content
        knowMoreButton.setOnClickListener {
            val intent = Intent(baseContext, CustomWebView::class.java)
            intent.putExtra("url", activityContent.url)
            startActivity(intent)
        }
    }
}
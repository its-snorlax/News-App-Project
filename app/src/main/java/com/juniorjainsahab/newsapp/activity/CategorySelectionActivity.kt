package com.juniorjainsahab.newsapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.R.layout.activity_category

class CategorySelectionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var topNews: View
    private lateinit var technology: View
    private lateinit var science: View
    private lateinit var finance: View
    private lateinit var entertainment: View
    private lateinit var sports: View
    private lateinit var health: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_category)
        bindingViews()
        updateBackGroundAndHeadings()

        topNews.setOnClickListener(this)
        technology.setOnClickListener(this)
        science.setOnClickListener(this)
        finance.setOnClickListener(this)
        entertainment.setOnClickListener(this)
        sports.setOnClickListener(this)
        health.setOnClickListener(this)
    }

    private fun bindingViews() {
        topNews = findViewById<View>(R.id.top_news)
        technology = findViewById<LinearLayout>(R.id.category_one).findViewById<View>(R.id.tech)
        science = findViewById<LinearLayout>(R.id.category_one).findViewById<View>(R.id.science)
        finance = findViewById<LinearLayout>(R.id.category_two).findViewById<View>(R.id.finance)
        entertainment =
            findViewById<LinearLayout>(R.id.category_two).findViewById<View>(R.id.entertainment)
        sports = findViewById<LinearLayout>(R.id.category_three).findViewById<View>(R.id.sports)
        health = findViewById<LinearLayout>(R.id.category_three).findViewById<View>(R.id.health)
    }

    private fun updateBackGroundAndHeadings() {
        topNews.findViewById<TextView>(R.id.category_heading).text = getString(R.string.top_news)
        topNews.findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.top_news))

        technology.findViewById<TextView>(R.id.category_heading).text =
            getString(R.string.technology)
        technology.findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.technology))

        science.findViewById<TextView>(R.id.category_heading).text = getString(R.string.science)
        science.findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.science))


        finance.findViewById<TextView>(R.id.category_heading).text = getString(R.string.finance)
        finance.findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.finance))


        entertainment
            .findViewById<TextView>(R.id.category_heading).text = "Entertainment"
        entertainment
            .findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.entertainment))


        sports.findViewById<TextView>(R.id.category_heading).text = "Sports"
        sports.findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.sports))


        health.findViewById<TextView>(R.id.category_heading).text = "Health"
        health.findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.health))
    }

    override fun onClick(v: View?) {
        when (v) {
            topNews -> startActivity(Intent(this, ArticlesActivity::class.java))
            technology -> openActivity("Technology")
            science -> openActivity("Science")
            finance -> openActivity("Finance")
            entertainment -> openActivity("Entertainment")
            sports -> openActivity("Sports")
            health -> openActivity("Health")
        }
    }

    private fun openActivity(catName: String) {
        val intent = Intent(this, CategoryArticlesActivity::class.java)
        intent.putExtra("categoryName", catName)
        startActivity(intent)
    }
}
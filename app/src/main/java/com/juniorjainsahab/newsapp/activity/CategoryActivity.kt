package com.juniorjainsahab.newsapp.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.juniorjainsahab.newsapp.R

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        updateBackGroundAndHeadings()
    }

    private fun updateBackGroundAndHeadings() {
        findViewById<View>(R.id.top_news).findViewById<TextView>(R.id.category_heading).text =
            getString(R.string.top_news)
        findViewById<View>(R.id.top_news).findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.top_news))

        findViewById<LinearLayout>(R.id.category_one).findViewById<View>(R.id.tech)
            .findViewById<TextView>(R.id.category_heading).text = getString(R.string.technology)
        findViewById<LinearLayout>(R.id.category_one).findViewById<View>(R.id.tech)
            .findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.technology))

        findViewById<LinearLayout>(R.id.category_one).findViewById<View>(R.id.science)
            .findViewById<TextView>(R.id.category_heading).text = getString(R.string.science)
        findViewById<LinearLayout>(R.id.category_one).findViewById<View>(R.id.science)
            .findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.science))


        findViewById<LinearLayout>(R.id.category_two).findViewById<View>(R.id.finance)
            .findViewById<TextView>(R.id.category_heading).text = getString(R.string.finance)
        findViewById<LinearLayout>(R.id.category_two).findViewById<View>(R.id.finance)
            .findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.finance))



        findViewById<LinearLayout>(R.id.category_two).findViewById<View>(R.id.entertainment)
            .findViewById<TextView>(R.id.category_heading).text = "Entertainment"
        findViewById<LinearLayout>(R.id.category_two).findViewById<View>(R.id.entertainment)
            .findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.entertainment))


        findViewById<LinearLayout>(R.id.category_three).findViewById<View>(R.id.sports)
            .findViewById<TextView>(R.id.category_heading).text = "Sports"
        findViewById<LinearLayout>(R.id.category_three).findViewById<View>(R.id.sports)
            .findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.sports))


        findViewById<LinearLayout>(R.id.category_three).findViewById<View>(R.id.health)
            .findViewById<TextView>(R.id.category_heading).text = "Health"
        findViewById<LinearLayout>(R.id.category_three).findViewById<View>(R.id.health)
            .findViewById<ImageView>(R.id.category_image)
            .setImageDrawable(getDrawable(R.drawable.health))
    }
}
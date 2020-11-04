package com.juniorjainsahab.newsapp.activity

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.fragment.ArticlesFragment
import com.juniorjainsahab.newsapp.model.Articles

class ArticlesActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentContainer = findViewById(R.id.fragment_container)

        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.fragment_container, ArticlesFragment())
        beginTransaction.addToBackStack(null)
        beginTransaction.commit();
    }
}

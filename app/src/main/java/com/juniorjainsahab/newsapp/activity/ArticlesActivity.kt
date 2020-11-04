package com.juniorjainsahab.newsapp.activity

import android.os.Bundle
import android.view.Menu
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.R.id.fragment_container
import com.juniorjainsahab.newsapp.R.layout.activity_main
import com.juniorjainsahab.newsapp.fragment.ArticlesFragment
import com.juniorjainsahab.newsapp.model.Articles

class ArticlesActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        fragmentContainer = findViewById(fragment_container)

        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(fragment_container, ArticlesFragment())
        beginTransaction.addToBackStack(null)
        beginTransaction.commit();
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}

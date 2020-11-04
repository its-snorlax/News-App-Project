package com.juniorjainsahab.newsapp.activity

import android.R.anim.slide_in_left
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MenuItem.OnMenuItemClickListener
import android.widget.FrameLayout
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.juniorjainsahab.newsapp.R.id.action_search
import com.juniorjainsahab.newsapp.R.id.fragment_container
import com.juniorjainsahab.newsapp.R.layout.activity_main
import com.juniorjainsahab.newsapp.R.menu.articles_actvity_menu
import com.juniorjainsahab.newsapp.SearchQueryListener
import com.juniorjainsahab.newsapp.fragment.ArticlesFragment
import com.juniorjainsahab.newsapp.fragment.SearchFragment


class ArticlesActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout

    private lateinit var searchFragment: SearchFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        fragmentContainer = findViewById(fragment_container)
        searchFragment = SearchFragment()

        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(fragment_container, ArticlesFragment())
        beginTransaction.addToBackStack(null)
        beginTransaction.commit();
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(articles_actvity_menu, menu)
        val searchAction = menu?.findItem(action_search)
        val searchView = searchAction?.actionView as SearchView
        searchView.setOnQueryTextListener(SearchQueryListener(searchFragment))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val searchMenu = menu!!.findItem(action_search)
        searchMenu.setOnMenuItemClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.setTransitionStyle(slide_in_left)
            fragmentTransaction.replace(fragment_container, searchFragment)
            fragmentTransaction.addToBackStack("true")
            fragmentTransaction.commit()
            true
        }
        return super.onPrepareOptionsMenu(menu)
    }
}

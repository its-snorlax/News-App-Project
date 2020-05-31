package com.juniorjainsahab.newsapp.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.juniorjainsahab.newsapp.R
import com.juniorjainsahab.newsapp.model.Articles
import com.squareup.picasso.Picasso
import java.net.URL

class ArticlesAdapter(private val articles: List<Articles>) :
    RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.news_list_view_item, parent, false)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val currentArticle = articles[position]
        holder.titleTextView.text = currentArticle.title
        Picasso.get().load(currentArticle.urlToImage).into(holder.imageView)
    }

    class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image_view)
        var titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
    }
}
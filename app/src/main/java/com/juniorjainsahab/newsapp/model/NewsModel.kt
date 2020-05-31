package com.juniorjainsahab.newsapp.model

class NewsModel(
    status: String,
    totalResults: Int,
    articles: List<Articles>
) {
    var articles = articles
        set(value) {
            field = value
        }
    var totalResults = totalResults
        set(value) {
            field = value
        }
    var status = status
        set(value) {
            field = value
        }
}
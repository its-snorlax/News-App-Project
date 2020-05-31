package com.juniorjainsahab.newsapp.model

import java.io.Serializable

class Articles(
    author: String,
    title: String,
    urlToImage: String,
    description: String,
    url: String
) : Serializable {
    var author = author
        get() = field
        set(value) {
            field = value
        }
    var title = title
        get() = field
        set(value) {
            field = value
        }
    var urlToImage = urlToImage
        get() = field
        set(value) {
            field = value
        }
    var discription = description
        get() = field
        set(value) {
            field = value
        }
    var url = url
        get() = field
        set(value) {
            field = value
        }
}

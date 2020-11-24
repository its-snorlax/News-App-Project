package com.juniorjainsahab.newsapp.model

import java.io.Serializable

class Articles(
    internal var author: String,
    internal var title: String,
    internal var urlToImage: String,
    internal var description: String,
    internal var url: String
) : Serializable

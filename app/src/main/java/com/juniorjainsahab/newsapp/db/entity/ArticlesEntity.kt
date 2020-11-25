package com.juniorjainsahab.newsapp.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticlesEntity(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "urlToImage") var urlToImage: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "url") var url: String,
    @PrimaryKey(autoGenerate = true)
    val uId: Int = 0
)
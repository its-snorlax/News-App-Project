package com.juniorjainsahab.newsapp.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.juniorjainsahab.newsapp.db.entity.ArticlesEntity

@Dao
interface ArticlesDao {
    @Insert
    fun insertAll(article: ArticlesEntity)

    @Delete
    fun delete(article: ArticlesEntity)
}
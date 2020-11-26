package com.juniorjainsahab.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juniorjainsahab.newsapp.db.dao.ArticlesDao
import com.juniorjainsahab.newsapp.db.entity.ArticlesEntity

@Database(entities = [ArticlesEntity::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao

    companion object {

        @Volatile
        private var appDB: AppDB? = null

        fun getDbInstance(context: Context): AppDB {
            synchronized(this) {
                var instance = appDB

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDB::class.java,
                        "news_app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    appDB = instance
                }
                return instance
            }
        }
    }
}
package com.example.homework

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WatchItem::class], version = 1)
abstract class WatchListDatabase : RoomDatabase() {
    abstract fun watchListDao(): WatchListDao

    companion object {
        @Volatile
        private var INSTANCE: WatchListDatabase? = null

        fun getDatabase(context: Context): WatchListDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WatchListDatabase::class.java,
                    "watch_list_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

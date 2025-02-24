package com.example.homework

import androidx.room.*

@Dao
interface WatchListDao {
    @Query("SELECT * FROM watch_list")
    fun getAllItems(): List<WatchItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: WatchItem)

    @Update
    suspend fun updateItem(item: WatchItem)

    @Delete
    suspend fun deleteItem(item: WatchItem)
}

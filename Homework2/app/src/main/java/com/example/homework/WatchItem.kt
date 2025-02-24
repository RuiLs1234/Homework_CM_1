package com.example.homework

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_list")
data class WatchItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val isWatched: Boolean
)

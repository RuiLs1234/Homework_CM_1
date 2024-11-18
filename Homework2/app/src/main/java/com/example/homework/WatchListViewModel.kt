package com.example.homework

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class WatchItem(val name: String, var isWatched: Boolean = false)

class WatchListViewModel : ViewModel() {
    private val _watchList = mutableStateListOf(
        WatchItem("The Lord of the Rings"),
        WatchItem("Game of Thrones"),
        WatchItem("Breaking Bad")
    )
    val watchList: List<WatchItem> get() = _watchList

    fun addItem(itemName: String) {
        if (itemName.isNotBlank()) {
            _watchList.add(WatchItem(itemName))
        }
    }

    fun toggleWatched(index: Int) {
        _watchList[index] = _watchList[index].copy(isWatched = !_watchList[index].isWatched)
    }

    fun removeItem(index: Int) {
        _watchList.removeAt(index)
    }
}


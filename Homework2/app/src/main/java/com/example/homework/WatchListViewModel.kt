package com.example.homework
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext




class WatchListViewModel(application: Application) : AndroidViewModel(application) {
    private val database = WatchListDatabase.getDatabase(application)
    private val watchListDao = database.watchListDao()

    var watchList = mutableStateListOf<WatchItem>()
        private set

    init {
        loadItems()
    }


    private fun loadItems() {
        viewModelScope.launch(Dispatchers.IO) { // Fetch data in background
            val items = watchListDao.getAllItems()
            withContext(Dispatchers.Main) { // Switch back to main thread to modify UI state
                watchList.clear()
                watchList.addAll(items)
            }
        }
    }




    fun addItem(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            watchListDao.insertItem(WatchItem(name = name, isWatched = false))
            loadItems() // Reload the list
        }
    }

    fun toggleWatched(index: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val item = watchList[index].copy(isWatched = !watchList[index].isWatched)
            watchListDao.updateItem(item)
            loadItems()
        }
    }

    fun removeItem(index: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            watchListDao.deleteItem(watchList[index])
            loadItems()
        }
    }



}



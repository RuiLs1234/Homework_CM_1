package com.example.homework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.homework.ui.theme.HomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeworkTheme {
                val watchListViewModel: WatchListViewModel = viewModel()
                WatchListApp(watchListViewModel)
            }
        }
    }
}

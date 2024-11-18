package com.example.homework

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background

@Composable
fun WatchListApp(viewModel: WatchListViewModel) {
    var newItemName by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("My Watch List", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = newItemName,
            onValueChange = { newItemName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)) // background modifier
                .padding(8.dp) // Added padding inside the background
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.addItem(newItemName.text)
            newItemName = TextFieldValue("") // Reset text field after adding item
        }) {
            Text("Add to Watch List")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(viewModel.watchList.size) { index ->
                val item = viewModel.watchList[index]
                WatchListItem(
                    name = item.name,
                    isWatched = item.isWatched,
                    onWatchedToggle = { viewModel.toggleWatched(index) },
                    onDelete = { viewModel.removeItem(index) }
                )
            }
        }
    }
}

@Composable
fun WatchListItem(
    name: String,
    isWatched: Boolean,
    onWatchedToggle: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(name, style = MaterialTheme.typography.bodyLarge)
            Text(if (isWatched) "Watched" else "To Watch", style = MaterialTheme.typography.bodySmall)
        }
        Row {
            Button(onClick = onWatchedToggle) {
                Text(if (isWatched) "Unwatch" else "Watch")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onDelete, colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)) {
                Text("Delete")
            }
        }
    }
}

package com.example.courts.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.EventsListQuery
import com.example.courts.data.EventViewModel


@Composable
fun HomeScreen(goToAdd: () -> Unit, goToFind: () -> Unit, modifier: Modifier = Modifier) {
    val viewModel: EventViewModel = viewModel()
    val events by viewModel.uiState.collectAsState()


    Column(modifier = modifier) {
        Text("Home")
        Button(onClick = goToAdd, modifier = Modifier.height(40.dp)) {
            Text(text = "Go To Add")
        }
        Button(onClick = goToFind, modifier = Modifier.height(40.dp)) {
            Text(text = "Go To Find")
        }
        LazyColumn {
            items(events.size) { i ->
                // Replace this with your actual UI code
                Text(events[i].id)
            }
        }
    }
}
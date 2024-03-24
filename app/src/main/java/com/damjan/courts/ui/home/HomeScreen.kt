package com.damjan.courts.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.damjan.courts.R
import com.damjan.courts.data.EventViewModel


@Composable
fun HomeScreen(goToAdd: () -> Unit, goToFind: () -> Unit, modifier: Modifier = Modifier) {
    val viewModel: EventViewModel = viewModel()
    val events by viewModel.uiState.collectAsState()


    Column(modifier = modifier) {
        Text("Home")
        Button(onClick = goToAdd,colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.accent)), modifier = Modifier
            .height(40.dp)) {
            Text(text = "Go To Add")
        }
        Button(onClick = goToFind,colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.secondary)), modifier = Modifier.height(40.dp)) {
            Text(text = "Go To Find")
        }
        LazyColumn {
            items(events.size) { i ->
                Text(events[i].id)
            }
        }
    }
}
package com.example.courts.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(goToAdd: () -> Unit, goToFind: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Home")
        Button(onClick = goToAdd, modifier = Modifier.height(40.dp)) {
            Text(text = "Go To Add")
        }
        Button(onClick = goToFind, modifier = Modifier.height(40.dp)) {
            Text(text = "Go To Find")
        }
    }
}
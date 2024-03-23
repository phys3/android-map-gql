package com.example.courts.ui.find_event

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.courts.data.EventViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun FindEventScreen(modifier: Modifier) {
    val viewModel: EventViewModel = viewModel()
    val events by viewModel.closestEventsState.collectAsState()
    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            onMapClick = { viewModel.getClosestEvents(latitude = it.latitude, longitude = it.longitude)}
        ) {
            events.forEach { event ->
                Marker(
                    state = MarkerState(position = LatLng(event.event_location.latitude, event.event_location.longitude)),
                    title = event.id,
                    snippet = event.host_user_uid
                )
            }
        }
    }
}
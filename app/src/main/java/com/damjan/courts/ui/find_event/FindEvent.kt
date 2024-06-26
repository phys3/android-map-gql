package com.damjan.courts.ui.find_event

import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.damjan.courts.data.EventViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun FindEventScreen(modifier: Modifier) {
    val viewModel: EventViewModel = viewModel()
    val events by viewModel.closestEventsState.collectAsState()
    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.matchParentSize(),
             onMapClick = { viewModel.getClosestEvents(latitude = it.latitude, longitude = it.longitude)},
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
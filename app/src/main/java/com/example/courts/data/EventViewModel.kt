package com.example.courts.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.EventsByProximityQuery
import com.example.EventsListQuery
import com.example.type.Event
import com.example.type.EventLocationOutput
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.json.JSONObject


class EventViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<List<EventsListQuery.Event>>(listOf())
    val uiState: StateFlow<List<EventsListQuery.Event>> = _uiState.asStateFlow()

    private fun getEvents() {
        viewModelScope.launch {
            val eventsRepository = NetworkEventsRepository()
            val response = eventsRepository.getEvents()

            if (response.hasErrors()) {
                response.errors?.get(0)?.let { Log.d("ERORROGETEVENTS", it.message) }
            } else {
                val listResults = response.data?.events
                if (listResults != null) {
                    listResults[0]?.let { Log.d("GETEVENTS", it.id) }
                    _uiState.value = listResults as List<EventsListQuery.Event>
                }
            }
        }
    }
    private val _closestEventsState = MutableStateFlow<List<EventsByProximityQuery.GetEventsByProximity>>(listOf())
    val closestEventsState: StateFlow<List<EventsByProximityQuery.GetEventsByProximity>> = _closestEventsState.asStateFlow()

    fun getClosestEvents(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            val eventsRepository = NetworkEventsRepository()
            val response = eventsRepository.getClosestEvents(latitude, longitude)
Log.d("xxx", latitude.toString() + longitude.toString())
            if (response.hasErrors()) {
                response.errors?.get(0)?.let { Log.d("ERRORGETCLOSESTEVENTS", it.message) }
            } else {
                val listResults = response.data!!.getEventsByProximity
                if (listResults != null) {
                    _closestEventsState.value = listResults as List<EventsByProximityQuery.GetEventsByProximity>
                }
            }
        }
    }


    }
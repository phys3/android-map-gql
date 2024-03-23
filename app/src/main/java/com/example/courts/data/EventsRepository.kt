package com.example.courts.data

import android.util.Log
import com.apollographql.apollo3.api.ApolloResponse
import com.example.EventsByProximityQuery
import com.example.EventsListQuery
import com.example.courts.apolloClient
import com.example.type.Event
import com.example.type.EventLocationOutput

interface EventsRepository {
    suspend fun getEvents(): ApolloResponse<EventsListQuery.Data>
    suspend fun  getClosestEvents(latitude: Double, longitude: Double): ApolloResponse<EventsByProximityQuery.Data>
}


class NetworkEventsRepository: EventsRepository {
    override suspend fun getEvents(): ApolloResponse<EventsListQuery.Data> {
        return apolloClient.query(EventsListQuery()).execute()
    }
    override suspend fun getClosestEvents(latitude: Double, longitude: Double): ApolloResponse<EventsByProximityQuery.Data> {
        return apolloClient.query(EventsByProximityQuery(latitude,longitude)).execute()
    }
}
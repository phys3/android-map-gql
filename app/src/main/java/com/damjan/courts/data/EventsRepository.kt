package com.damjan.courts.data

import android.util.Log
import com.apollographql.apollo3.api.ApolloResponse
import com.damjan.EventsByProximityQuery
import com.damjan.EventsListQuery
import com.damjan.courts.apolloClient
import com.damjan.type.Event
import com.damjan.type.EventLocationOutput

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
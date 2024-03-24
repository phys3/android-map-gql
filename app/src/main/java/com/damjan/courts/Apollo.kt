package com.damjan.courts

import com.apollographql.apollo3.ApolloClient

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://2ef3-86-33-66-111.ngrok-free.app/graphql")
    .build()
package com.damjan.courts

import com.apollographql.apollo3.ApolloClient

val apolloClient = ApolloClient.Builder()
    .serverUrl(BuildConfig.BE_API_URL)
    .build()
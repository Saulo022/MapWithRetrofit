package com.saulo.mapwithretrofit.data.network.response

data class Metadata(
    val attribution: String,
    val engine: Engine,
    val query: Query,
    val service: String,
    val timestamp: Long
)
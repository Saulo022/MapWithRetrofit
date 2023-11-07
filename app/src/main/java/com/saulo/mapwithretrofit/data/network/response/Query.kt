package com.saulo.mapwithretrofit.data.network.response

data class Query(
    val locations: List<List<Double>>,
    val profile: String,
    val responseType: String
)
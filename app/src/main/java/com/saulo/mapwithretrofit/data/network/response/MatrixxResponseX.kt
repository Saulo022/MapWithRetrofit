package com.saulo.mapwithretrofit.data.network.response

data class MatrixxResponseX(
    val destinations: List<Destination>,
    val durations: List<List<Double>>,
    val metadata: Metadata,
    val sources: List<Source>
)
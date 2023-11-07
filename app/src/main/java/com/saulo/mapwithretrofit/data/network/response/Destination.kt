package com.saulo.mapwithretrofit.data.network.response

data class Destination(
    val location: List<Double>,
    val snapped_distance: Double
)
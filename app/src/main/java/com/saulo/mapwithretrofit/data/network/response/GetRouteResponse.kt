package com.saulo.mapwithretrofit.data.network.response

import com.google.gson.annotations.SerializedName

data class GetRouteResponse(@SerializedName("features") val features: List<Features>)
data class Features(@SerializedName("geometry") val geometry: Geometries)
data class Geometries(@SerializedName("coordinates") val coordinates: List<List<Double>>)



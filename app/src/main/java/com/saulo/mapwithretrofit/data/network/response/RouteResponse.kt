package com.saulo.mapwithretrofit.data.network.response

data class RouteResponse( val features: List<Feature>)
data class Feature( val geometry: Geometry, val properties: Properties)
data class Geometry( val coordinates: List<Double>)
data class Properties( val label: String)


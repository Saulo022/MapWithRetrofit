package com.saulo.mapwithretrofit.data.network

import com.saulo.mapwithretrofit.data.network.response.RouteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("/geocode/search")
    suspend fun search(
        @Query("api_key") apiKey: String,
        @Query("text") text: String,
        @Query("boundary.circle.lon", encoded = true) long: String,
        @Query("boundary.circle.lat", encoded = true) lat: String,
        @Query("boundary.circle.radius") radius: Int,
        @Query("boundary.country") country: String
    ) : Response<RouteResponse>
}
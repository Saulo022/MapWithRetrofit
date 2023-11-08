package com.saulo.mapwithretrofit.data.network

import com.saulo.mapwithretrofit.data.network.response.GetRouteResponse
import com.saulo.mapwithretrofit.data.network.response.MatrixResponse
import com.saulo.mapwithretrofit.data.network.response.MatrixxResponseX
import com.saulo.mapwithretrofit.data.network.response.RouteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
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

    @Headers("Authorization: 5b3ce3597851110001cf6248430006dcbe134f72aea0f41e3b68d35b")
    @POST("/v2/matrix/driving-car")
    suspend fun optimisedRoute(@Body matrix: Matrix) : Response<MatrixxResponseX>

    @GET("/v2/directions/driving-car")
    suspend fun getRoute(
        @Query("api_key") apiKey: String,
        @Query("start") start: String,
        @Query("end") end: String
    ): Response<GetRouteResponse>

}

data class Matrix(val locations: List<List<Double>>)
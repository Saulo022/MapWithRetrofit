package com.saulo.mapwithretrofit.data.network

import com.saulo.mapwithretrofit.data.network.response.Feature
import com.saulo.mapwithretrofit.data.network.response.Features
import javax.inject.Inject

class ApiRepository @Inject constructor(private val api: ApiService){
    //private val api = ApiService()

    suspend fun doSearch(apiKey: String, text: String, long: String, lat: String, radius: Int, country: String): List<Feature>{
        return api.doSearch(apiKey, text, long, lat, radius, country)
    }

    suspend fun doOptimisedRoute(matrix: Matrix): List<List<Double>>{
        return api.doOptimisedRoute(matrix)
    }

    suspend fun doRoute(apiKey: String, start: String, end: String): List<Features> {
        return api.doRoute(apiKey, start, end)
    }
}
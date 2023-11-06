package com.saulo.mapwithretrofit.data.network

import com.saulo.mapwithretrofit.data.network.response.Feature
import javax.inject.Inject

class ApiRepository @Inject constructor(private val api: ApiService){
    //private val api = ApiService()

    suspend fun doSearch(apiKey: String, text: String, long: String, lat: String, radius: Int, country: String): List<Feature>{
        return api.doSearch(apiKey, text, long, lat, radius, country)
    }
}
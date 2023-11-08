package com.saulo.mapwithretrofit.data.network

import com.saulo.mapwithretrofit.data.network.response.Feature
import com.saulo.mapwithretrofit.data.network.response.Features
import com.saulo.mapwithretrofit.data.network.response.MatrixResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class ApiService @Inject constructor(private val apiClient: ApiClient) {
    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doSearch(apiKey: String, text: String, long: String, lat: String, radius: Int, country: String) : List<Feature> {
        return withContext(Dispatchers.IO){
            val response = apiClient.search(apiKey, text, long, lat, radius, country)
            response.body()?.features ?: emptyList()
        }
    }

    suspend fun doOptimisedRoute(matrix: Matrix) : List<List<Double>> {
        return withContext(Dispatchers.IO){
            val response = apiClient.optimisedRoute(matrix)
            response.body()?.durations ?: emptyList()
        }
    }

    suspend fun doRoute(apiKey: String, start: String, end: String) : List<Features> {
        return withContext(Dispatchers.IO){
            val response = apiClient.getRoute(apiKey, start, end)
            response.body()?.features ?: emptyList()
        }
    }


}
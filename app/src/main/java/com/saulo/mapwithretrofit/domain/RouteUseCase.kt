package com.saulo.mapwithretrofit.domain

import com.saulo.mapwithretrofit.data.network.ApiRepository
import com.saulo.mapwithretrofit.data.network.Matrix
import com.saulo.mapwithretrofit.data.network.response.Feature
import com.saulo.mapwithretrofit.data.network.response.Features
import javax.inject.Inject

class RouteUseCase @Inject constructor(private val repository: ApiRepository) {

    suspend operator fun invoke(apiKey: String, start: String, end: String): List<Features> {
        return repository.doRoute(apiKey, start, end)
    }

}
package com.saulo.mapwithretrofit.domain

import com.saulo.mapwithretrofit.data.network.ApiRepository
import com.saulo.mapwithretrofit.data.network.response.Feature
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: ApiRepository) {
    //private val repository = ApiRepository()

    suspend operator fun invoke(apiKey: String, text: String, long: String, lat: String, radius: Int, country: String): List<Feature> {
        return repository.doSearch(apiKey, text, long, lat, radius, country)
    }
}
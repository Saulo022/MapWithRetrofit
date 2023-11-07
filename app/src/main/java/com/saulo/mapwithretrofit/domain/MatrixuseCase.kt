package com.saulo.mapwithretrofit.domain

import com.saulo.mapwithretrofit.data.network.ApiRepository
import com.saulo.mapwithretrofit.data.network.Matrix
import com.saulo.mapwithretrofit.data.network.response.Feature
import javax.inject.Inject

class MatrixuseCase @Inject constructor(private val repository: ApiRepository) {

    suspend operator fun invoke(matrix: Matrix): List<List<Double>> {
        return repository.doOptimisedRoute(matrix)
    }
}
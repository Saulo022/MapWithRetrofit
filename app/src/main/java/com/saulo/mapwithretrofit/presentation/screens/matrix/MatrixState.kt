package com.saulo.mapwithretrofit.presentation.screens.matrix

import com.saulo.mapwithretrofit.data.network.Matrix


data class MatrixState(

    var matrix: Matrix = Matrix(
        listOf(
            listOf(9.70093, 48.477473),
            listOf(9.207916, 49.153868),
            listOf(37.573242, 55.801281),
            listOf(115.663757, 38.106467)
        )
    ),

    var numero: String = ""

)


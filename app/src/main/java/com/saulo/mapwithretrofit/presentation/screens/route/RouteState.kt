package com.saulo.mapwithretrofit.presentation.screens.route

import com.saulo.mapwithretrofit.data.network.Matrix
import com.saulo.mapwithretrofit.data.network.response.Feature
import com.saulo.mapwithretrofit.data.network.response.Features


data class RouteState(

    var lista: List<Features> = emptyList(),

    var numero: String = ""

)


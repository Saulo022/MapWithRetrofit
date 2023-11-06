package com.saulo.mapwithretrofit.presentation.screens.home

import com.saulo.mapwithretrofit.data.network.response.Feature

data class SearchState (
    var search: String = ""
)

data class SearchListState (
    var searchList: List<Feature> = emptyList()
)
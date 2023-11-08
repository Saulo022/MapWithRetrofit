package com.saulo.mapwithretrofit.presentation.screens.route

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulo.mapwithretrofit.domain.RouteUseCase
import com.saulo.mapwithretrofit.presentation.screens.home.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RouteViewModel @Inject constructor(private val routeUseCase: RouteUseCase): ViewModel() {

    var state by mutableStateOf(RouteState())
        private set

    fun onRoute() {
        viewModelScope.launch {
            val result = routeUseCase(
                apiKey = "5b3ce3597851110001cf6248430006dcbe134f72aea0f41e3b68d35b",
                start = "-15.4134300,28.0997300",
                end = "-15.46629,28.04716"
            )
            state = state.copy(lista = result)
            Log.d("Saulo", "onRouteViewModel: OK + ${result}")
        }
    }
}
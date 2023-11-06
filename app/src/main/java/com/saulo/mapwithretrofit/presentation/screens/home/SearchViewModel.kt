package com.saulo.mapwithretrofit.presentation.screens.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulo.mapwithretrofit.data.network.response.Feature
import com.saulo.mapwithretrofit.domain.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchUseCase: SearchUseCase) : ViewModel() {

    //val searchUseCase = SearchUseCase()

    //STATE SEARCH FORM
    var state by mutableStateOf(SearchState())
        private set

    //STATE SEARCH LIST FORM
    var stateList by mutableStateOf(SearchListState())
        private set

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    /*
    fun onSearchSelected() {
        viewModelScope.launch {
            val result = searchUseCase(
                apiKey = "5b3ce3597851110001cf6248430006dcbe134f72aea0f41e3b68d35b",
                text = "Lanzarote",
                long = "-15.4134300",
                lat = "28.0997300",
                radius = "50",
                country = "ES"
            )
            Log.d("Saulo", "onSearchSelected: OK + $result")
        }
    }
     */

    fun onSearchInput(search: String) {
        state = state.copy(search = search)
    }

    fun onSearchSelected() {
        viewModelScope.launch {
            val result = searchUseCase(
                apiKey = "5b3ce3597851110001cf6248430006dcbe134f72aea0f41e3b68d35b",
                text = state.search,
                long = "-15.4134300",
                lat = "28.0997300",
                radius = 50,
                country = "ES"
            )
            stateList = stateList.copy(searchList = result)
            Log.d("Saulo", "onSearchSelected: OK + $result")
        }
    }


}
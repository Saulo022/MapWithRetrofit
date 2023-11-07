package com.saulo.mapwithretrofit.presentation.screens.matrix

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulo.mapwithretrofit.data.network.Matrix
import com.saulo.mapwithretrofit.domain.MatrixuseCase
import com.saulo.mapwithretrofit.domain.SearchUseCase
import com.saulo.mapwithretrofit.presentation.screens.home.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatrixViewModel @Inject constructor(private val matrixuseCase: MatrixuseCase) : ViewModel() {

    var state by mutableStateOf(MatrixState())
        private set


    fun onMatrix() {
        viewModelScope.launch {

            val result = matrixuseCase(
                matrix = Matrix(
                    locations = listOf(
                        listOf(9.70093, 48.477473),
                        listOf(9.207916, 49.153868),
                        listOf(37.573242, 55.801281),
                        listOf(115.663757, 38.106467)
                    )
                )
            )
            //state = state.copy(numero = result[1].toString())
            Log.d("Saulo", "onMatrixViewModel: OK + ${result[0]}")
        }
    }
}
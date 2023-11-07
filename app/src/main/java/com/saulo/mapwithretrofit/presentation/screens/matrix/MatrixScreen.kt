package com.saulo.mapwithretrofit.presentation.screens.matrix

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MatrixScreen(matrixViewModel: MatrixViewModel) {

    Column() {
        Text(text= matrixViewModel.state.numero)

        Button(onClick = { matrixViewModel.onMatrix() }){}
    }


}
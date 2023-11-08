package com.saulo.mapwithretrofit.presentation.screens.route

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties


@Composable
fun RouteScreen(routeViewMode: RouteViewModel) {

    Column() {
        //Text(text = routeViewMode.state.lista)
        GoogleMap(modifier = Modifier.fillMaxSize())
        Button(onClick = { routeViewMode.onRoute() }) {

        }
    }
}
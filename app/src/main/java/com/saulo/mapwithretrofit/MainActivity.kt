package com.saulo.mapwithretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saulo.mapwithretrofit.presentation.screens.ExposedDropdownMenu.ExposedDropdownMenuScreen
import com.saulo.mapwithretrofit.presentation.screens.datepicker.DatePickerDialogScreen
import com.saulo.mapwithretrofit.presentation.screens.datepicker.DatePickerScreen
import com.saulo.mapwithretrofit.presentation.screens.datepicker.SelectableDatesScreen
import com.saulo.mapwithretrofit.presentation.screens.datepicker.SimpleDatePicker
import com.saulo.mapwithretrofit.presentation.screens.home.SearchScreen
import com.saulo.mapwithretrofit.presentation.screens.home.SearchViewModel
import com.saulo.mapwithretrofit.ui.theme.MapWithRetrofitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapWithRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SearchScreen(searchViewModel = searchViewModel)
                    //ExposedDropdownMenuScreen()
                    //DatePickerScreen()
                    //SimpleDatePicker()
                    //SelectableDatesScreen()
                    //DatePickerDialogScreen()
                }
            }
        }
    }
}

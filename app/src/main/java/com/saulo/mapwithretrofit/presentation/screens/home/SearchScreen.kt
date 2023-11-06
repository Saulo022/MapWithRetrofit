package com.saulo.mapwithretrofit.presentation.screens.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(searchViewModel: SearchViewModel) {

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val ctx = LocalContext.current

    val state = searchViewModel.state
    val stateList = searchViewModel.stateList

    Scaffold {
        SearchBar(
            query = state.search,
            onQueryChange = {
                searchViewModel.onSearchInput(it)
                searchViewModel.onSearchSelected()
            },
            onSearch = {
                Toast.makeText(ctx, state.search, Toast.LENGTH_LONG).show()
                //searchViewModel.onSearchSelected()
                active = false
            },
            active = active,
            onActiveChange = { active = it }) {



            /*
            filteredSearchs.forEach {
                Text(text = it.properties.label)
            }*/

            LazyColumn(modifier = Modifier.fillMaxSize()) {

                val filteredSearchs = stateList.searchList.filter { it.properties.label.contains(state.search, true) }

                items(filteredSearchs) { result ->
                    // Make the item clickable
                    Text(
                        text = result.properties.label,
                        modifier = Modifier.padding(8.dp).clickable {
                            // Do something when the item is clicked
                        },
                    )
                }
            }

        }


    }


}

@Composable
fun SearchContent(searchViewModel: SearchViewModel) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(verticalArrangement = Arrangement.SpaceEvenly) {

            TextField(value = "", onValueChange = { })

            Spacer(modifier = Modifier.height(10.dp))

            //Button(onClick = { searchViewModel.onSearchSelected() }) {

            Text(text = "Buscar")
            //}

        }
    }

}


package com.saulo.mapwithretrofit.presentation.screens.datepicker
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerScreen() {
// Decoupled snackbar host state from scaffold state for demo purposes.
val snackState = remember { SnackbarHostState() }
val snackScope = rememberCoroutineScope()
SnackbarHost(hostState = snackState, Modifier)
val openDialog = remember { mutableStateOf(true) }
// TODO demo how to read the selected date from the state.
if (openDialog.value) {
    val datePickerState = rememberDatePickerState()
    val confirmEnabled = derivedStateOf { datePickerState.selectedDateMillis != null }
    DatePickerDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            openDialog.value = false
        },
        confirmButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                    snackScope.launch {
                        snackState.showSnackbar(
                            "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                        )
                    }
                },
                enabled = confirmEnabled.value
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}
}